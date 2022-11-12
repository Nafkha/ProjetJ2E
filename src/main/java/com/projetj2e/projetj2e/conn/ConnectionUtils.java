package com.projetj2e.projetj2e.conn;

import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.System.out;

public class ConnectionUtils {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        out.println("Succés");
        return MySQLConnUtils.getMySQLConnection();


    }

    public  static  void closeQuietly(Connection conn){
        try{
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
