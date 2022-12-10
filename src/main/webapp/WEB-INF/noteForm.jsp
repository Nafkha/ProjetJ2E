<%@ page import="java.sql.Connection" %>
<%@ page import="com.projetj2e.projetj2e.conn.MyUtils" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: nafkh
  Date: 08/12/2022
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/inc/css/style.css"%></style>
<div class="form_container">
<h3>Ajouter Note</h3>
    <form method="post" action="${pageContext.request.contextPath}/Notes">
        <label>Etudiant</label>
        <%
            Connection conn = MyUtils.getStoredConnection(request);

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select p.nom,p.prenom, e.num_insc from personne p join etudiant e on p.id = e.id");
        %>
        <select name="etu">
            <%                 while (rs.next()){%>
            <option value="<%=rs.getInt(3)%>"><%= rs.getString(1) + " "+rs.getString(2)%></option>
            <%}%>
        </select>
        <%}catch (SQLException e){e.printStackTrace();}%>

        <label>Matiere</label>
        <%
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT idMat from MATIERE");
        %>
        <select name="matiere">
            <%while (rs.next()){%>

            <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>
            <%}%>
        </select>
        <%}catch (SQLException e){e.printStackTrace();}%>
        <label>Note</label>
        <input type="text" placeholder="Note" name="note">
        <label>Nombre des notes</label>
        <select name="Type">
            <option value="DS">DS</option>
            <option value="TP">TP</option>
            <option value="Examen">Examen</option>
        </select>


        <input type="submit" value="Ajouter Note">


    </form>
</div>