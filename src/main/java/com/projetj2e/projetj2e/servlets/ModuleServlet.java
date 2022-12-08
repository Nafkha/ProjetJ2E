package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.beans.Etudiant;
import com.projetj2e.projetj2e.beans.GroupeModule;
import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.EtudiantUtils;
import com.projetj2e.projetj2e.conn.dbutils.GroupeModuleUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;

@WebServlet(urlPatterns = "/module")
public class ModuleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Dashboard/Module.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom_module = request.getParameter("nom_module");
        String groupe = request.getParameter("groupe");
        String id_module = nom_module + '-' + groupe;
        GroupeModule gm = new GroupeModule(id_module,nom_module,0,groupe);
        Connection conn = MyUtils.getStoredConnection(request);
        GroupeModuleUtils.insertGroupeModule(conn,gm);
    }
}
