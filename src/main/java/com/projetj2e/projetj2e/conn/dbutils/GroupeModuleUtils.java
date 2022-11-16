package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.GroupeModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GroupeModuleUtils {
    public static void insertGroupeModule(Connection con, GroupeModule gm){
        try{
            PreparedStatement pstmt  = con.prepareStatement("INSERT INTO GROUPEMODULE VALUES (?,?,?,?)");
            pstmt.setString(1,gm.getIdGM());
            pstmt.setString(2,gm.getNomGM());
            pstmt.setDouble(3,gm.getCoefGM());
            pstmt.setString(4,gm.getGrp());
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
