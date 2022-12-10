package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.beans.Matiere;
import com.projetj2e.projetj2e.beans.Note;
import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.MatiereUtils;
import com.projetj2e.projetj2e.conn.dbutils.NoteUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/modifierNote"})
public class ChangerNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String code = (String) request.getParameter("code");
        int etu = Integer.parseInt((String) request.getParameter("etu"));
        String type = (String) request.getParameter("type");
        System.out.println(code + " "+etu);
        Note n =null;
        n = NoteUtils.findNote(conn,code,etu,type);
        request.setAttribute("Note",n);
        System.out.println(n.getMat());
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Dashboard/modifierNote.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String code = (String) request.getParameter("code");
        int etu = Integer.parseInt((String) request.getParameter("etu"));
        String type = (String) request.getParameter("type");
        Double note = Double.parseDouble(request.getParameter("nouvelleNote"));
        NoteUtils.modifierNote(conn,code,etu,type,note);
        response.sendRedirect(request.getContextPath() + "/Dashboard/Notes.jsp");


    }
}
