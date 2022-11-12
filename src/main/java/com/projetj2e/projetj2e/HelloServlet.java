package com.projetj2e.projetj2e;

import com.projetj2e.projetj2e.beans.Personne;
import com.projetj2e.projetj2e.conn.DBUtils;
import com.projetj2e.projetj2e.conn.MyUtils;
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
        ResultSet rs = PersonneUtils.fetchPersonnes(con);
        try{
            while (rs.next()){
                System.out.println(rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/");
        rd.forward(req, resp);
    }

    public void destroy() {
    }
}