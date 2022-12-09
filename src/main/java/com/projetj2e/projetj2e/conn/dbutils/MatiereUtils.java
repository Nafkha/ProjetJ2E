package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.Matiere;

import java.sql.*;

public class MatiereUtils {
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
}
