package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.beans.Enseignant;
import com.projetj2e.projetj2e.beans.Personne;
import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.EnseignantUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/enseignant")
public class EnseignantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Dashboard/Enseigngants.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cin, nom, prenom, mail, sexe, date_naissance, cnss;
        cin = request.getParameter("cin");
        nom = request.getParameter("nom");
        prenom = request.getParameter("prenom");
        sexe = request.getParameter("sexe");
        date_naissance = request.getParameter("date_naissance");
        cnss = request.getParameter("cnss");
        mail = prenom.substring(0,1).toLowerCase()+"."+nom.replaceAll(" ","").toLowerCase()+"@pi.tn";
        Connection conn = MyUtils.getStoredConnection(request);
        Enseignant e = new Enseignant(Integer.parseInt(cin),nom,prenom,mail,sexe,date_naissance,Integer
                .parseInt(cnss));

        EnseignantUtils.insertEnseignant(conn,e);

    }
}
