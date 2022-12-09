<%@ page import="com.projetj2e.projetj2e.conn.MyUtils" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: nafkh
  Date: 08/12/2022
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/inc/css/style.css"%></style>
<%
    Connection conn = MyUtils.getStoredConnection(request);
    try{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(" select idGrp,niveau,diplome,specialite,num_g from groupe ");
%>

<table>
    <tr>
        <th>ID</th>
        <th>Niveau</th>
        <th>Diplome</th>
        <th>Specialité</th>
        <th>Numéro Groupe</th>
        <th></th>
    </tr>
    <% while (rs.next()){%>
    <tr>
        <td><%=rs.getString(1)%></td>
        <td><%=rs.getString(2)%></td>
        <td><%=rs.getString(3)%></td>
        <td><%=rs.getString(4)%></td>
        <td><%=rs.getInt(5)%></td>
        <td><a href="${pageContext.request.contextPath}/deleteGroupe?code=<%=rs.getString(1)%>">Supprimer</td>
    </tr>
    <%}%>
</table>
<%}catch (SQLException e){e.printStackTrace();}%>