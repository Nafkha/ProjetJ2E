package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EtudiantUtils {
    public static void insertEtudiant(Connection con, Etudiant et){
        try{
            PersonneUtils.insertPersonne(con,et);
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO ETUDIANT VALUES(?,?,?,?,?) ");
            pstmt.setInt(1, et.getNumInsc());
            pstmt.setInt(2,et.getCin());
            pstmt.setString(3, et.getGrp());
            pstmt.setString(4,et.getData_insc());
            pstmt.setInt(5,et.getNumGrp());
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void changerGroupe(Connection con, int idEtu, String idGr){
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE ETUDIANT SET GRP=? WHERE num_insc=?");
            System.out.println(idEtu);
            System.out.println(idGr);
            pstmt.setString(1,idGr);
            pstmt.setInt(2,idEtu);
            pstmt.execute();
        }catch (SQLException e){

        }

    }
    public static Etudiant findEtudiant(Connection con, int idEtu)throws SQLException{
        PreparedStatement pstmt = con.prepareStatement("SELECT e.num_insc, p.nom, p.prenom, p.mail,e.grp from etudiant e join personne p where(e.num_insc = ?)");
        pstmt.setInt(1,idEtu);
        ResultSet rs = pstmt.executeQuery();
        Etudiant e = new Etudiant();
        while (rs.next()){
            e.setNumInsc(rs.getInt(1));
            e.setNom(rs.getString(2));
            e.setPrenom(rs.getString(3));
            e.setMail(rs.getString(4));
            e.setGrp(rs.getString(5));

        }
        return  e;

    }

}
