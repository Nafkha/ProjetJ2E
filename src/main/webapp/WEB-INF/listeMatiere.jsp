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
        ResultSet rs = stmt.executeQuery("select m.idMat,m.nomMat,m.coef, m.gm , p.nom, p.prenom from matiere m " +
                "join enseignant e on m.ens = e.cnss join personne p on p.id = e.id");
%>

<table>
    <tr>
        <th>ID</th>
        <th>Nom Matiere</th>
        <th>Coeffecient</th>
        <th>Module</th>
        <th>Enseignant</th>
        <th></th>
    </tr>
    <% while (rs.next()){%>
    <tr>
        <td><%=rs.getString(1)%></td>
        <td><%=rs.getString(2)%></td>
        <td><%=rs.getDouble(3)%></td>
        <td><%=rs.getString(4)%></td>
        <td><%=rs.getString(5) + " " + rs.getString(6)%></td>
        <td><a href="${pageContext.request.contextPath}/deleteMatiere?code=<%=rs.getString(1)%>">Supprimer</td>
    </tr>
    <%}%>
</table>
<%}catch (SQLException e){e.printStackTrace();}%>