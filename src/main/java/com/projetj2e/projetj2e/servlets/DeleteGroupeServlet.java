package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.GroupeUtils;
import com.projetj2e.projetj2e.conn.dbutils.PersonneUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/deleteGroupe"})
public class DeleteGroupeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String code = (String) request.getParameter("code");

        String errorString = null;
        try {
            GroupeUtils.deleteGroupe(conn,code);
        } catch (SQLException e) {
            response.sendRedirect(request.getContextPath() + "/Dashboard/Groupe.jsp" );

        }
        response.sendRedirect(request.getContextPath() + "/Dashboard/Groupe.jsp" );


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
