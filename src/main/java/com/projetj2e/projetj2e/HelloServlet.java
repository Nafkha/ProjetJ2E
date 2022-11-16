package com.projetj2e.projetj2e;

import com.projetj2e.projetj2e.beans.*;
import com.projetj2e.projetj2e.conn.DBUtils;
import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.*;

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
        Etudiant et = new Etudiant(634,"Bennour","Mohamed","b.mohamed@pi.tn","M","1998-05-20",
                21224,"123","2022",1);
        EnseignantUtils.insertEnseignant(con,e);
        Groupe g = new Groupe("123","1ere","IRM","BDBI",1);
        GroupeUtils.insertGroupe(con,g);
        GroupeModule gm  = new GroupeModule("123","Math",3.5,"123");
        GroupeModuleUtils.insertGroupeModule(con,gm);
        Matiere m = new Matiere("123","IA",3.5,123,"123",3);
        MatiereUtils.insertMatiere(con,m);
        EtudiantUtils.insertEtudiant(con,et);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/");
        rd.forward(req, resp);
    }

    public void destroy() {
    }
}