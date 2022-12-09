<%--
  Created by IntelliJ IDEA.
  User: nafkh
  Date: 08/12/2022
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/inc/css/style.css"%></style>
<div class="sidebar">

   <img src="${pageContext.request.contextPath}/inc/Logo-Pi-RVB.png" class="logo" alt="logopi">
   <ul>
      <li><a href="${pageContext.request.contextPath}/Dashboard/Etudiants.jsp">Etudiants</a> </li>
      <li><a href="${pageContext.request.contextPath}/Dashboard/Enseigngants.jsp">Enseignants</a> </li>
      <li><a href="${pageContext.request.contextPath}/Dashboard/Matieres.jsp">Matieres</a> </li>
      <li><a href="${pageContext.request.contextPath}/Dashboard/Module.jsp">Modules</a> </li>
      <li><a href="${pageContext.request.contextPath}/Dashboard/Groupe.jsp">Groupe</a> </li>
   </ul>


</div>