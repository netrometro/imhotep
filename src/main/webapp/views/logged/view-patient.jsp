<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%@include file="/views/includes/links-css.jsp" %>

    <title>Paciente</title>
</head>
<body>
<%@include file="/views/includes/navbar.jsp" %>
<main>
    <div class="container">
        <%@ page import="br.upe.model.entities.User" %>
        <% User patient = (User) request.getAttribute("patient"); %>
        <h3 style="font-weight: 600; margin-top: 2em;">Informações sobre o Paciente:</h3>
        <br><br>

        <span style="font-weight: 600;">Nome: </span><span><%= patient.getName() %></span><br>
        <span style="font-weight: 600;">Data de nascimento: </span><span><%= patient.getBirthday() %></span><br>
        <span style="font-weight: 600;">Email: </span><span><%= patient.getEmail() %></span><br>
        <span style="font-weight: 600;">CPF: </span><span><%= patient.getCpf() %></span><br>
    </div>
</main>
<%@include file="/views/includes/footer.jsp" %>
<%@include file="/views/includes/scripts-js.jsp" %>
</body>
</html>