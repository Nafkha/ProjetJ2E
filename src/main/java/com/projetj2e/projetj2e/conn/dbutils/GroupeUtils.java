package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.Groupe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GroupeUtils {
    public static void insertGroupe(Connection con, Groupe grp){
        try{
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO GROUPE VALUES (?,?,?,?,?)");
            pstmt.setString(1,grp.getIdGrp());
            pstmt.setString(2, grp.getNiveau());
            pstmt.setString(3, grp.getDiplome());
            pstmt.setString(4, grp.getSpecialite());
            pstmt.setInt(5,grp.getNumGrp());
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
