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
        ResultSet rs = stmt.executeQuery("select * from note");
%>

<table>
    <tr>
        <th>Code Etudiant</th>
        <th>Nom Matiere</th>
        <th>Note</th>
        <th>Type</th>
        <th></th>
        <th></th>
    </tr>
    <% while (rs.next()){%>
    <tr>
        <td><%=rs.getInt(2)%></td>
        <td><%=rs.getString(1)%></td>
        <td><%=rs.getDouble(3)%></td>
        <td><%=rs.getString(4)%></td>
        <td><a href="${pageContext.request.contextPath}/deleteNote?code=<%=rs.getString(1)%>&etu=<%=rs.getInt(2)%>&type=<%=rs.getString(4)%>">Supprimer</td>
        <td><a href="${pageContext.request.contextPath}/modifierNote?code=<%=rs.getString(1)%>&etu=<%=rs.getInt(2)%>&type=<%=rs.getString(4)%>">Modifier</td>
    </tr>
    <%}%>
</table>
<%}catch (SQLException e){e.printStackTrace();}%>