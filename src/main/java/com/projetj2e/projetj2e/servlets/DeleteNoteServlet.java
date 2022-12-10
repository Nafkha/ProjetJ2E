package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.NoteUtils;
import com.projetj2e.projetj2e.conn.dbutils.PersonneUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = {"/deleteNote"})
public class DeleteNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String code = (String) request.getParameter("code");
        int etu = Integer.parseInt((String) request.getParameter("etu"));
        String type = (String) request.getParameter("type");
        System.out.println("Matiere : "+code+" Etudiant : "+etu+" Type : "+type);
        NoteUtils.deleteNote(conn,code,etu,type);
        response.sendRedirect(request.getContextPath() + "/Dashboard/Notes.jsp" );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
