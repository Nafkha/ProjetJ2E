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
        ResultSet rs = stmt.executeQuery(" select e.num_insc,p.nom,p.prenom,p.mail,p.id,e.grp from etudiant e join personne p on p.id = e.id ");
%>

<table>
    <tr>
        <th>Numero Inscription</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Email</th>
        <th>Groupe</th>
        <th></th>
        <th></th>
    </tr>
    <% while (rs.next()){%>
    <tr>
        <td><%=rs.getInt(1)%></td>
        <td><%=rs.getString(2)%></td>
        <td><%=rs.getString(3)%></td>
        <td><%=rs.getString(4)%></td>
        <td><%=rs.getString(6)%></td>
        <td><a href="${pageContext.request.contextPath}/deleteEtudiant?code=<%=rs.getInt(5)%>">Supprimer</td>
        <td><a href="${pageContext.request.contextPath}/modifierEtudiant?code=<%=rs.getInt(1)%>">Modifier</td>
    </tr>
    <%}%>
</table>
<%}catch (SQLException e){e.printStackTrace();}%>