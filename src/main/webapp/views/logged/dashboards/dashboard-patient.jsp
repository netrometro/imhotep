<%@include file="/views/includes/start.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'/>
    <link href="<%= request.getContextPath()%>/resources/css/calendar/fullcalendar.css" rel="stylesheet"/>
    <link href="<%= request.getContextPath()%>/resources/css/calendar/stylecalendar.css" rel="stylesheet"/>
    <link href="<%= request.getContextPath()%>/resources/css/calendar/fullcalendar.print.min.css" rel='stylesheet'
          media='print'/>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/moment.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/jquery.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/fullcalendar.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/language/pt-br.js"></script>
    <br>
</head>
<body>

<div>
    <div class="container" style="min-height: 100vh;">
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

<%@include file="/views/includes/end.jsp" %>

