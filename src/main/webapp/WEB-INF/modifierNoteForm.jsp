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
        <span>Nom Matiere : ${Note.getMat()}</span>
        <span>Code Etudiant : ${Note.getEtu()} </span>

        <span>Note : ${Note.getNote()} </span>

        <span>Type : ${Note.getType()}</span>
        <h3>Modifier Note</h3>
        <form method="post" action="${pageContext.request.contextPath}/modifierNote?code=${Note.getMat()}&etu=${Note.getEtu()}&type=${Note.getType()}">

            <input type="text" placeholder="Note" name="nouvelleNote">
            <input type="submit" value="Changer note">

        </form>

    </div>


</div>


