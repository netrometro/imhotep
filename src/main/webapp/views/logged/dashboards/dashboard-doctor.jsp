<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/views/includes/links-css.jsp" %>
        <script>
                times = []
                let dados = ""
                $.ajax({
                    url: "<%= request.getContextPath()%>/logged/doctor/gettimes",
                    type: "post",
                    data: dados,
                    dataType: 'json',
                    success: function (json) {
                        let arr = $.map(json, function (el) {
                            return el;
                        })

                        for (value of arr) {
                            times.push({
                                title: value.period,
                                start: value.dateString,
                                data: value,
                            });
                        }

                        $(document).ready(function () {
                            $('#calendar').fullCalendar({
                                header: {
                                    center: 'month,agendaWeek,agendaDay,listWeek, addEventButton',
                                    right: 'today, prev,next', //'addEventButton',
                                    left: 'title',
                                },
                                defaultDate: Date(),
                                navLinks: true, // can click day/week names to navigate views
                                editable: true,
                                eventLimit: true, // allow "more" link when too many events

                                events: times,
                            });
                        });
                    },
                    error: function () {
                        msg.text("Erro ao fazer requisição");
                    }
                });
        </script>
        <title>Dashboard do Médico</title>
</head>
<body>
    <%@include file="/views/includes/navbar.jsp" %>
    <main>
        <div class="title-dashboard">
            <h2>Horários marcados como livre</h2>
        </div>
        <div id='calendar' style="margin-top: 2em;"></div>
    </main>
    <%@include file="/views/includes/footer.jsp" %>
    <%@include file="/views/includes/scripts-js.jsp" %>
    <%@include file="/views/includes/scripts-js.jsp" %>
</body>
</html>