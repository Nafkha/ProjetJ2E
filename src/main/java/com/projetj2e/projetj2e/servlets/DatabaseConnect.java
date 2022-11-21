package com.projetj2e.projetj2e.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet(name = "DatabaseConnect", value = "/DatabaseConnect")
public class DatabaseConnect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Connection con = DatabaseConnection.initializeDatabase();
                out.println("Connecté");
        }catch (SQLException | ClassNotFoundException e){
            out.println("Erreur :'(");
            e.printStackTrace();

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
