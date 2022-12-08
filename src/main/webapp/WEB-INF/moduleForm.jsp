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
<h3>Modules</h3>
    <form method="post" action="${pageContext.request.contextPath}/module">
        <label>Nom Module</label>
        <input type="text" name="nom_module" placeholder="Nom Module">
        <%
            try {


            Connection conn = MyUtils.getStoredConnection(request);
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("Select distinct idGRP from groupe ");

        %>
        <label>Groupe</label>
        <select name="groupe">
            <% while (resultSet.next()){%>
            <option value="<%= resultSet.getString(1)%>"><%= resultSet.getString(1)%></option>
            <%}%>


        </select>
        <%
            }catch (SQLException e){

            }
        %>




    <input type="submit" value="Ajouter Module">


    </form>
</div>