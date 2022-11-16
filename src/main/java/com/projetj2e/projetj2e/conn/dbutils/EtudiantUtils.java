package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
