<%@ page import="com.projetj2e.projetj2e.conn.MyUtils" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: nafkh
  Date: 09/12/2022
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/inc/css/style.css"%></style>
<div class="modification">
    <div class="information_etudiant">
        <h3>Information Matiere</h3>
        <span>Nom Matiere : ${Matiere.nomMat}</span>
        <span>Coef : ${Matiere.coef} </span>

        <span>Groupe Module : ${Matiere.gm} </span>

        <span>Nombre des notes : ${Matiere.nbnotes}</span>
        <h3>Modifier Groupe</h3>
        <form method="post" action="${pageContext.request.contextPath}/changerEnsMatiere?code=${Matiere.idMat}">
            <%
    try {


      Connection conn = MyUtils.getStoredConnection(request);
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery("Select e.cnss, p.nom,p.prenom from enseignant e join personne p on e.id=p.id ");

  %>
  <select name="ens">
        <% while (resultSet.next()){%>
        <option value="<%= resultSet.getInt(1)%>"><%= resultSet.getString(2) + " "+ resultSet.getString(3)%></option>
        <%}%>


        </select>
        <%
            }catch (SQLException e){

            }
        %>
        <input type="submit" value="Modifier Enseignant">

        </form>
        <form method="post" action="${pageContext.request.contextPath}/changerCoefMatiere?code=${Matiere.idMat}">
            <label>Nouvelle Coeffecient</label>
            <input type="text" name="nouvcoef" placeholder="Coeffecient">
            <input type="submit" value="Modifier Coeffecient">
        </form>

    </div>


</div>


