<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <%@include file="/views/includes/links-css.jsp" %>

    <title>Procurar por Médicos</title>
</head>
<body>
<%@include file="/views/includes/navbar.jsp" %>
<main>
<div>
    <div class="m-container" style="min-height: 100vh;">
        <br>
        <form onsubmit="event.preventDefault();">
            <div class="form-group d-flex justify-content-end" >
                <input type="text" class="form-control" id="specialties" placeholder="Especialidades ou Nome" aria-describedby="emailHelp" placeholder="">
                <button class="btn btn-second" onclick="searchForDoctorSpecialty()">Procurar</button>
            </div>

        </form>
        <br>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome do Médico</th>
                <th scope="col">Crm</th>
                <th scope="col">Email</th>
                <th scope="col">Especialização</th>
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
                <td><%= doctor.getSpecialties() %>
                </td>
                <td>
                    <form action="<%= request.getContextPath()%>/logged/patient/scheduling-doctor.jsp" method="post">
                        <input type="hidden" name="id" value="<%= doctor.getId() %>"/>
                        <button class="btn btn-second" >Agendamento</button>
                    </form>
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
<script>
    function searchForDoctorSpecialty(){
        let value = document.getElementById("specialties").value;
        console.log(value);
        window.location.href = updateQueryStringParameter(window.location.href, "specialties", value);
    }
    function updateQueryStringParameter(uri, key, value) {
        var re = new RegExp("([?&])" + key + "=.*?(&|$)", "i");
        var separator = uri.indexOf('?') !== -1 ? "&" : "?";
        if (uri.match(re)) {
            return uri.replace(re, '$1' + key + "=" + value + '$2');
        }
        else {
            return uri + separator + key + "=" + value;
        }
    }
    function goToDoctorDashboard(id) {
        console.log("Selected id=" + id);
    }
</script>
</body>
</html>


