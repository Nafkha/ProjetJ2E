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
<h3>Ajouter Matiere</h3>
    <form method="post" action="${pageContext.request.contextPath}/matiere">
        <label>Nom matiere</label>
        <input type="text" name="nom_matiere" placeholder="Nom Matiere">
        <label>Module</label>
        <%
            Connection conn = MyUtils.getStoredConnection(request);
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT idGM from groupemodule");
        %>
        <select name="module">
            <%while (rs.next()){%>

            <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>
            <%}%>
        </select>
        <%}catch (SQLException e){e.printStackTrace();}%>
        <label>Coeffecient</label>
        <input type="text" placeholder="Coeffecient" name="coef">
        <label>Nombre des notes</label>
        <select name="nb_notes">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
        <label>Enseignant</label>
        <%
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select p.nom,p.prenom, e.cnss from personne p join enseignant e on p.id = e.id");
        %>
        <select name="enseignant">
            <%                 while (rs.next()){%>
            <option value="<%=rs.getInt(3)%>"><%= rs.getString(1) + " "+rs.getString(2)%></option>
            <%}%>
        </select>
        <%}catch (SQLException e){e.printStackTrace();}%>


        <input type="submit" value="Ajouter Matiere">


    </form>
</div>