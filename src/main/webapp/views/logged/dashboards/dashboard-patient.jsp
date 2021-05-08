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
    <script>
        times = []
        let dados = ""
        $.ajax({
            url: "<%= request.getContextPath()%>/logged/patient/getdoctor",
            type: "post",
            data: dados,
            dataType: 'json',
            success: function (json) {
                let arr = $.map(json, function (el) {
                    console.log(arr)
                    return el;
                })

                for (value of arr) {
                    times.push({
                        title: value.period,
                        start: value.dateString,
                        data: value,
                    });
                }
            },
            error: function () {
                msg.text("Erro ao fazer requisição");
            }
        });

    </script>

</head>
<body>
<div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nome</th>
            <th scope="col">CRM</th>

        </tr>
        </thead>
        <tbody>
        <tr>


                <%@ page import="br.upe.model.entities.User" %>
                <%@ page import="java.util.List" %>
                <% List<User> doctors = (List<User>) request.getAttribute("doctors"); %>

                <% for (int i = 0; i < doctors.size(); i++) { %>
                <th scope="row"><%doctors.get(i).getId();%></th>
                <td><%doctors.get(i).getName();%></td>
                <td><%doctors.get(i).getCrm();%></td>
                <% }; %>



        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>

        </tr>
        <tr>
            <th scope="row">3</th>
            <td colspan="2">Larry the Bird</td>

        </tr>
        </tbody>
    </table>
</div>

<%@include file="/views/includes/end.jsp" %>

