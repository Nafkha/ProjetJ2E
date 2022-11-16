package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.Matiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        }catch (SQLException e){
            e.printStackTrace();

        }
    }
}
