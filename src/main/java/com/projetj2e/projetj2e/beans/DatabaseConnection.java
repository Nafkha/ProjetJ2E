package com.projetj2e.projetj2e.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initializeDatabase() throws SQLException,ClassNotFoundException {
        String db = "jdbc:mysql://localhost:3306/";
        String dbName = "projetj2e";
        String username = "root";
        String password = "admin";
        Connection con = DriverManager.getConnection(db+dbName,username,password);
        return con;
    }
}