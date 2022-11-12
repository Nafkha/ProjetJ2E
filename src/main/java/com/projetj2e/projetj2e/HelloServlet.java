package com.projetj2e.projetj2e;

import com.projetj2e.projetj2e.beans.Enseignant;
import com.projetj2e.projetj2e.beans.Personne;
import com.projetj2e.projetj2e.conn.DBUtils;
import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.EnseignantUtils;
import com.projetj2e.projetj2e.conn.dbutils.PersonneUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = MyUtils.getStoredConnection(req);
        Enseignant e = new Enseignant(123,"Nafkha","Mohamed Youssef","Nafkha.m.youssef@gmail.com",
                "m","1998-05-20",123) ;
        EnseignantUtils.insertEnseignant(con,e);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/");
        rd.forward(req, resp);
    }

    public void destroy() {
    }
}