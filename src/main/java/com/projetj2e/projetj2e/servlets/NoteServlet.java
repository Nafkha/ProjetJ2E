package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.beans.Matiere;
import com.projetj2e.projetj2e.beans.Note;
import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.MatiereUtils;
import com.projetj2e.projetj2e.conn.dbutils.NoteUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = "/Notes")
public class NoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Dashboard/Notes.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String nom_matiere = request.getParameter("nom_matiere");
        String module = request.getParameter("module");
        Double coef = Double.parseDouble(request.getParameter("coef"));
        int nbNotes = Integer.parseInt(request.getParameter("nb_notes"));
        int ens = Integer.parseInt(request.getParameter("enseignant"));
        String id_mat = nom_matiere + '-' + module;
        Connection conn = MyUtils.getStoredConnection(request);
        Matiere m = new Matiere(id_mat,nom_matiere,coef,ens,module,nbNotes);
        MatiereUtils.insertMatiere(conn,m);
        response.sendRedirect(request.getContextPath() + "/Dashboard/Matieres.jsp" );*/
        /*pstmt.setString(1,note.getMat());
        pstmt.setInt(2,note.getEtu());
        pstmt.setDouble(3,note.getNote());
        pstmt.setString(4,note.getType());
        pstmt.execute();*/
        String Matiere = request.getParameter("matiere");
        int etu = Integer.parseInt((String) request.getParameter("etu"));
        Double note = Double.parseDouble((String) request.getParameter("note"));
        String type = (String) request.getParameter("Type");
        Note n = new Note(Matiere,etu,note,type);
        Connection conn = MyUtils.getStoredConnection(request);
        NoteUtils.insertNote(conn,n);
        response.sendRedirect(request.getContextPath() + "/Dashboard/Notes.jsp");

    }
}
