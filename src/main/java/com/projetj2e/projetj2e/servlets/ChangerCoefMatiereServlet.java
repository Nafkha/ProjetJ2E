package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.beans.Etudiant;
import com.projetj2e.projetj2e.beans.Matiere;
import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.EtudiantUtils;
import com.projetj2e.projetj2e.conn.dbutils.MatiereUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/changerCoefMatiere"})
public class ChangerCoefMatiereServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String code = (String) request.getParameter("code");
        Matiere m = null;
        m = MatiereUtils.findMatiere(conn,code);
        request.setAttribute("Matiere",m);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Dashboard/modifierMatiere.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String code = (String) request.getParameter("code");
        Double coef = Double.parseDouble(request.getParameter("nouvcoef"));
        try {
            MatiereUtils.changerCoeffecient(conn,code,coef);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect(request.getContextPath() + "/Dashboard/Matieres.jsp");


    }
}
