<%@ page import="com.projetj2e.projetj2e.conn.DBUtils" %>
<%@ page import="com.projetj2e.projetj2e.conn.MyUtils" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: nafkh
  Date: 08/12/2022
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/inc/css/style.css"%></style>
<div class="form_container">
<h3>Etudiants</h3>
    <form method="post" action="${pageContext.request.contextPath}/etudiant">
    <label>CIN</label>
    <input type="text" name="cin" placeholder="CIN" >
    <label>Nom</label>
    <input type="text" name="nom" placeholder="nom" >
    <label>Prenom</label>
    <input type="text" name="prenom" placeholder="prenom" >
        <label>Sexe</label>

        <div class="sexe">
            <label>Homme</label>
            <input type="radio" value="M" name="sexe">
            <label>Femme</label>

            <input type="radio" value="F" name="sexe">
        </div>

    <label>Date de naissance</label>
    <input type="date" name="date_naissance">
        <%
            try {


            Connection conn = MyUtils.getStoredConnection(request);
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("Select distinct idGRP from groupe ");

        %>
        <select name="groupe">
            <% while (resultSet.next()){%>
            <option value="<%= resultSet.getString(1)%>"><%= resultSet.getString(1)%></option>
            <%}%>


        </select>
        <%
            }catch (SQLException e){

            }
        %>



    <input type="submit" value="Ajouter Etudiant">


    </form>
</div>