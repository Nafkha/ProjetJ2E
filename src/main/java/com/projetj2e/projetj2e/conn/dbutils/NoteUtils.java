package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteUtils {

    public static void insertNote(Connection con, Note note){
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO NOTE VALUES (?,?,?,?)");
            pstmt.setString(1,note.getMat());
            pstmt.setInt(2,note.getEtu());
            pstmt.setDouble(3,note.getNote());
            pstmt.setString(4,note.getType());
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();

        }
    }
    public static void deleteNote(Connection con, String mat, int etu, String type){
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM NOTE WHERE Mat=? and Etu=? and Type =?");
            pstmt.setString(1,mat);
            pstmt.setInt(2,etu);
            pstmt.setString(3,type);
            pstmt.execute();
        }catch (SQLException e){

        }
    }
    public static void modifierNote(Connection con, String mat, int etu, String type,double nouvelleNote){
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE NOTE set Note=? WHERE Mat=? and Etu=? and Type =?");
            pstmt.setDouble(1,nouvelleNote);
            pstmt.setString(2,mat);
            pstmt.setInt(3,etu);
            pstmt.setString(4,type);
            pstmt.execute();

        }catch (SQLException e){

        }
    }
    public static  Note findNote(Connection con, String mat, int etu, String type){
        Note n = new Note();
        try{
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM NOTE where Mat=? and Etu=? and Type=?");
            pstmt.setString(1,mat);
            pstmt.setInt(2,etu);
            pstmt.setString(3,type);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                n.setMat(rs.getString(1));
                n.setEtu(rs.getInt(2));
                n.setNote(rs.getDouble(3));
                n.setType(rs.getString(4));
            }

        }catch (SQLException e){

        }
        return n;
    }

}
