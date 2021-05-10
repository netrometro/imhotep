<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <%@include file="/views/includes/links-css.jsp" %>

    <title>Dashboard do Paciente</title>
</head>
<body>
<%@include file="/views/includes/navbar.jsp" %>
<main>
<div>
    <div class="m-container" style="min-height: 100vh;">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome do Médico</th>
                <th scope="col">Crm</th>
                <th scope="col">Email</th>
            </tr>
            </thead>
            <tbody>
            <%@ page import="br.upe.model.entities.User" %>
            <%@ page import="java.util.List" %>
            <% List<User> doctors = (List<User>) request.getAttribute("doctors"); %>

            <% for (int k = 0; k < doctors.size(); k++) {%>
            <tr>
                <th scope="row">1</th>
                <% User doctor = (User) doctors.get(k);%>
                <td><%= doctor.getName() %>
                </td>
                <td><%= doctor.getCrm() %>
                </td>
                <td><%= doctor.getEmail() %>
                </td>
                <% } %>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</main>
<%@include file="/views/includes/footer.jsp" %>
<%@include file="/views/includes/scripts-js.jsp" %>
<%@include file="/views/includes/scripts-js.jsp" %>
</body>
</html>


