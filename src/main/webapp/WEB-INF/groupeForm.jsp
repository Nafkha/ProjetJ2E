<%--
  Created by IntelliJ IDEA.
  User: nafkh
  Date: 08/12/2022
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/inc/css/style.css"%></style>
<div class="form_container">
<h3>Ajouter Groupe</h3>
    <form method="post" action="${pageContext.request.contextPath}/Groupe">
        <label>Diplome</label>
       <select id="Diplome" name="Diplome">
           <option value="Preparatoire">Préparatoire</option>
           <option value="Ingenieur">Ingénieur</option>
           <option value="Licence">Licence</option>
           <option value="Mastere">Mastère</option>
       </select>
        <label>Specialite</label>
        <select id="Specialite" name="Specialite">
           <option value="Informatique">Informatique</option>
           <option value="Mecatronique">Mécatronique</option>
           <option value="Architecture">Architecture</option>
       </select>
        <label>Niveau</label>
        <select id="Niveau" name="Niveau">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
        <input type="submit" value="Ajouter Groupe">


    </form>
</div>