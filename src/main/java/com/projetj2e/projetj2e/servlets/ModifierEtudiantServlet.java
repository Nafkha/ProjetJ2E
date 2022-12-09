package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.beans.Etudiant;
import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.EtudiantUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/modifierEtudiant"})
public class ModifierEtudiantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String code = (String) request.getParameter("code");
        int num_insc = Integer.parseInt(code);
        System.out.println(num_insc);
        Etudiant e = null;
        try {
             e = EtudiantUtils.findEtudiant(conn,num_insc);
        }catch (SQLException ex){
            System.out.println(ex);

        }
        request.setAttribute("Etudiant",e);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Dashboard/modifierEtudiant.jsp");
        dispatcher.forward(request,response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String code = (String) request.getParameter("code");
        int num_insc = Integer.parseInt(code);
        String groupe = (String) request.getParameter("groupe");
        EtudiantUtils.changerGroupe(conn,num_insc,groupe);
        response.sendRedirect(request.getContextPath() + "/Dashboard/Etudiants.jsp");



    }
}
