package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.beans.GroupeModule;
import com.projetj2e.projetj2e.beans.Matiere;
import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.GroupeModuleUtils;
import com.projetj2e.projetj2e.conn.dbutils.MatiereUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(urlPatterns = "/matiere")
public class MatiereServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Dashboard/Matiere.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom_matiere = request.getParameter("nom_matiere");
        String module = request.getParameter("module");
        Double coef = Double.parseDouble(request.getParameter("coef"));
        int nbNotes = Integer.parseInt(request.getParameter("nb_notes"));
        int ens = Integer.parseInt(request.getParameter("enseignant"));
        String id_mat = nom_matiere + '-' + module;
        Connection conn = MyUtils.getStoredConnection(request);
        Matiere m = new Matiere(id_mat,nom_matiere,coef,ens,module,nbNotes);
        MatiereUtils.insertMatiere(conn,m);
        response.sendRedirect(request.getContextPath() + "/Dashboard/Matieres.jsp" );



    }
}
