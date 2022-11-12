package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.Personne;

import java.sql.*;

import static java.lang.System.out;

public class PersonneUtils {
    public static void insertPersonne(Connection con, Personne p){
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO personne VALUES (?,?,?,?,?,?)");
            pstmt.setInt(1,p.getCin());
            pstmt.setString(2, p.getNom());
            pstmt.setString(3,p.getPrenom());
            pstmt.setString(4, p.getMail());
            pstmt.setString(5, p.getSexe());
            pstmt.setString(6, p.getDate_naissance());
            pstmt.execute();
            out.println("Ajout Personne Succées");

        }catch (SQLException e){
            out.println("Erreur d'ajout personne");
            e.printStackTrace();

        }
    }
    public static void deletePersonne(Connection con, int id){
        try {
            PreparedStatement stmt = con.prepareStatement("delete from personne where id=?");
            stmt.setInt(1,id);
            stmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static ResultSet fetchPersonnes(Connection con){
        ResultSet rs= null;
        try{
             rs = con.createStatement().executeQuery("SELECT * FROM personne");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
