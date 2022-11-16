package com.projetj2e.projetj2e.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
    public static Connection getMySQLConnection() throws SQLException,ClassNotFoundException {
        String db = "jdbc:mysql://localhost:3306/";
        String dbName = "projetj2e";
        String username = "root";
        String password = "admin";
        return getMySQLConnection(db,dbName,username,password);

    }
    public static Connection getMySQLConnection(String hostName, String dbName,String userName, String password) throws SQLException,ClassNotFoundException{
      //  Class.forName("com.mysql.jdbc.Driver");
        String connectionURL = hostName+dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        System.out.println(connectionURL);
        return conn;

    }

}
