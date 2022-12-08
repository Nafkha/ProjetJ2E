package com.projetj2e.projetj2e.servlets;

import com.projetj2e.projetj2e.beans.Enseignant;
import com.projetj2e.projetj2e.beans.Etudiant;
import com.projetj2e.projetj2e.conn.MyUtils;
import com.projetj2e.projetj2e.conn.dbutils.EnseignantUtils;
import com.projetj2e.projetj2e.conn.dbutils.EtudiantUtils;

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

@WebServlet(urlPatterns = "/etudiant")
public class EtudiantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Dashboard/Enseigngants.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int year = Calendar.getInstance().get(Calendar. YEAR);
        String y = String.valueOf(year);
        Connection conn = MyUtils.getStoredConnection(request);
        int nbEtudiant = 0;
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT count(*) from etudiant where(data_insc=?)");
            pstmt.setInt(1,year);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                nbEtudiant = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String num_insc = y.substring(2,4);
        if(nbEtudiant<10){
            num_insc += "00"+String.valueOf(nbEtudiant);
        }else if(nbEtudiant<100 && nbEtudiant>=10){
            num_insc+="0"+String.valueOf(nbEtudiant);
        }else{
            num_insc+=String.valueOf(nbEtudiant);
        }



        String cin, nom, prenom, mail, sexe, date_naissance;
        cin = request.getParameter("cin");
        nom = request.getParameter("nom");
        prenom = request.getParameter("prenom");
        sexe = request.getParameter("sexe");
        date_naissance = request.getParameter("date_naissance");
        String groupe = request.getParameter("groupe");
        mail = prenom.substring(0,1).toLowerCase(Locale.ROOT)+"."+nom.replaceAll(" ","").toLowerCase(Locale.ROOT)+num_insc+"@pi.tn";
        Etudiant e = new Etudiant(Integer.parseInt(cin),nom,prenom,mail,sexe,date_naissance
        ,Integer.parseInt(num_insc),groupe,Integer.toString(year),1);
        EtudiantUtils.insertEtudiant(conn,e);

    }
}
