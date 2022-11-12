package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.Enseignant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnseignantUtils {

    public static void insertEnseignant(Connection con, Enseignant ens){
        try{
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO ENSEIGNANT VALUES (?,?)");
            PersonneUtils.insertPersonne(con,ens);
            pstmt.setInt(1,ens.getCnss());
            pstmt.setInt(2,ens.getCin());
            pstmt.execute();
            System.out.println("Enseignant Inserée avec succées");

        }catch (SQLException e){
            if(e.getErrorCode()==1062){
                System.out.println("Cette CIN existe déja dans la base");
            }


        }
    }
    public static void deleteEnseignant(Connection con, int id){
        try{
            PreparedStatement pstmt  = con.prepareStatement("DELETE FROM ENSEIGNANT WHERE id=?");
            pstmt.setInt(1,id);
            pstmt.execute();
            PersonneUtils.deletePersonne(con,id);
            System.out.println("Enseignant Supprimé avec succées");



        }catch (SQLException e){
            System.out.println("Erreur Suppression");
            e.printStackTrace();
        }
    }

}
