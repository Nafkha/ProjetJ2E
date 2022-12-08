<%--
  Created by IntelliJ IDEA.
  User: nafkh
  Date: 08/12/2022
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/inc/css/form.css"%></style>
<form method="post" action="${pageContext.request.contextPath}/login">
  <label>Adresse email</label>
  <br/>
  <input class='form_input' type='text' name="userName" value="${user.userName}" placeholder="Email"/>
  <br/>
  <label>Mot de passe</label>
  <br/>
  <input class='form_input' type='password' name="password" value="${user.password}" placeholder="Password"/>
  <br/>
  <button class='subButton' type='submit'>Se Connecter</button>
</form>