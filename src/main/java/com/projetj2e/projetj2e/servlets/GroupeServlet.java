package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.conn.MyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/Groupe")
public class GroupeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Dashboard/Groupe.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String diplome = request.getParameter("Diplome");
        String specialite = request.getParameter("Specialite");
        String niveau = request.getParameter("Niveau");
        int numgrp = 0;
        String idGrp = diplome.substring(0,1)+specialite.substring(0,1)+niveau;
        Connection conn = MyUtils.getStoredConnection(request);

        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM GROUPE " +
                    "WHERE(idGrp = ?)");
            pstmt.setString(1,idGrp);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                numgrp = rs.getInt(1)+1;
            }

        }catch (SQLException e){

        }
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO GROUPE VALUES (?,?,?,?,?)");
            pstmt.setString(1,idGrp);
            pstmt.setString(2,niveau);
            pstmt.setString(3,diplome);
            pstmt.setString(4,specialite);
            pstmt.setInt(5,numgrp);
            pstmt.execute();
            response.sendRedirect(request.getContextPath() + "/Dashboard/Groupe.jsp" );

        }catch (SQLException e){
            e.printStackTrace();

        }
    }
}
