package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.MatiereUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/changerEnsMatiere"})
public class ChangerEnsMatiereServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String code = (String) request.getParameter("code");
        int ens = Integer.parseInt(request.getParameter("ens"));
        try {
            MatiereUtils.changerEnseignant(conn,code,ens);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect(request.getContextPath() + "/Dashboard/Matieres.jsp");



    }
}
