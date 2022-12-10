package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.Matiere;

import java.sql.*;

public class MatiereUtils {
    public static Matiere findMatiere(Connection con, String idMat){
        Matiere m = new Matiere();
        try{
            PreparedStatement pstmt = con.prepareStatement("SELECT  * FROM MATIERE where idMat=?");
            pstmt.setString(1,idMat);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                m.setIdMat(rs.getString(1));
                m.setNomMat(rs.getString(2));
                m.setCoef(rs.getDouble(3));
                m.setEns(rs.getInt(4));
                m.setGm(rs.getString(5));
                m.setNbnotes(rs.getInt(6));


            }


        }catch (SQLException e){

        }
        return m;
    }
    public static void insertMatiere(Connection con, Matiere mat){
        try{
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO MATIERE VALUES (?,?,?,?,?,?)");
            pstmt.setString(1,mat.getIdMat());
            pstmt.setString(2, mat.getNomMat());
            pstmt.setDouble(3,mat.getCoef());
            pstmt.setInt(4,mat.getEns());
            pstmt.setString(5,mat.getGm());
            pstmt.setInt(6,mat.getNbnotes());
            pstmt.execute();
            PreparedStatement stmt = con.prepareStatement("SELECT coefGM from groupemodule where(idGM = ?)");
            stmt.setString(1,mat.getGm());
            ResultSet rs = stmt.executeQuery();

            Double coefGM = 0.0;
            while(rs.next()){
                 coefGM = rs.getDouble(1);
            }
            coefGM+=mat.getCoef();
            pstmt = con.prepareStatement("UPDATE GROUPEMODULE set coefGM = ? where idGM = ? ");
            pstmt.setDouble(1,coefGM);
            pstmt.setString(2,mat.getGm());
            pstmt.execute();


        }catch (SQLException e){
            e.printStackTrace();

        }
    }
    public static void deleteMatiere(Connection con, String idMat)throws SQLException{
        PreparedStatement pstmt = con.prepareStatement("SELECT coef,gm from matiere where idMat=?");
        pstmt.setString(1,idMat);
        ResultSet rs = pstmt.executeQuery();
        String idGM = null;
        double coef = 0;
        while (rs.next()){
            idGM = rs.getString(2);
            coef = rs.getDouble(1);
        }
        pstmt = con.prepareStatement("SELECT coefGM from groupemodule where idGM= ? ");
        pstmt.setString(1,idGM);
        rs = pstmt.executeQuery();
        double coefGM = 0;
        while (rs.next()){
            coefGM = rs.getDouble(1);
        }
        coefGM-=coef;
        System.out.println(coefGM);
        pstmt = con.prepareStatement("UPDATE GROUPEMODULE SET coefGM=? where idGM=?");
        pstmt.setDouble(1,coefGM);
        pstmt.setString(2,idGM);
        pstmt.execute();
        pstmt = con.prepareStatement("DELETE FROM MATIERE WHERE idMat = ?");
        pstmt.setString(1,idMat);
        pstmt.execute();
    }
    public static void changerEnseignant(Connection con, String idMat,int cnss)throws SQLException{

        PreparedStatement pstmt = con.prepareStatement("UPDATE matiere SET ens=? where idMat= ?");
        pstmt.setInt(1,cnss);
        pstmt.setString(2,idMat);
        pstmt.execute();
    }
    public static void changerCoeffecient(Connection con, String idMat, double nouvCoef)throws SQLException{
        double coef = 0.0;
        String idGM = null;

        PreparedStatement stmt = con.prepareStatement("SELECT coef,gm FROM matiere where idMat=? ");
        stmt.setString(1,idMat);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            coef = rs.getDouble(1);
            idGM = rs.getString(2);
        }
        double coefDiff = nouvCoef-coef;
        stmt = con.prepareStatement("SELECT coefGM from groupemodule where idGM=? ");
        stmt.setString(1,idGM);
        rs = stmt.executeQuery();
        double coefGM = 0.0;
        while (rs.next()){
            coefGM = rs.getDouble(1);
        }
        coefGM += coefDiff;
        stmt = con.prepareStatement("UPDATE GROUPEMODULE set coefGM=? where idGM=?");
        stmt.setDouble(1,coefGM);
        stmt.setString(2,idGM);
        stmt.execute();
        stmt = con.prepareStatement("UPDATE MATIERE set coef=? where idMat=?");
        stmt.setDouble(1,nouvCoef);
        stmt.setString(2,idMat);
        stmt.execute();

    }
}
