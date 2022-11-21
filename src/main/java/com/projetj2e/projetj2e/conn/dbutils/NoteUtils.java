package com.projetj2e.projetj2e.conn.dbutils;

import com.projetj2e.projetj2e.beans.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
