package com.projetj2e.projetj2e.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {
    public static void insertSomething(Connection con){
        try {
            PreparedStatement pstmt = con.prepareStatement("insert into groupe values(?,?,?,?,?)");
            pstmt.setString(1,"Test");
            pstmt.setString(2,"Test");
            pstmt.setString(3,"Test");
            pstmt.setString(4,"Test");
            pstmt.setInt(5,1);
            pstmt.execute();
        }catch (SQLException e){

        }


    }
}
