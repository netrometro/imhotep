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
                console.log(arr)
                for (value of arr) {
                    const t = value.period.split("-");
                    let iduser = null;
                    let eColor = "#c7dfda"
                    if (value.idPatient){
                        iduser = value.idPatient;
                        eColor = "#E97F7F";
                    }
                    times.push({
                        title: value.namePatient,
                        start: value.dateString +"T"+ t[0],
                        end: value.dateString +"T"+ t[1],
                        //se o horario estiver agendado criar isso abaixo
                        idPatient: iduser,
                        //namePatient: iduser.toString(),
                        color: eColor,
                    });
                }
                console.log(times)
                $(document).ready(function () {
                    $('#calendar').fullCalendar({
                        header: {
                            center: 'agendaWeek',
                            right: 'today, prev,next', //'addEventButton',
                            left: 'title',
                        },
                        defaultDate: Date(),
                        navLinks: true, // can click day/week names to navigate views
                        eventLimit: true, // allow "more" link when too many events
                        events: times,
                        eventClick: function(info) {
                            if (info.idPatient) {
                                let url = "<%= request.getContextPath()%>/logged/doctor/view-patient.jsp?id="+info.idPatient;
                                let a = document.createElement('a');
                                a.href = url;
                                a.click();
                            }
                        },
                    });
                    const calendarWeek = document.getElementsByClassName("fc-agendaWeek-button");
                    calendarWeek[0].click();
                });
            },
            error: function () {
                msg.text("Erro ao fazer requisi????o");
            }
        });
    </script>
    <title>Dashboard do M??dico</title>
</head>
<body>
<%@include file="/views/includes/navbar.jsp" %>
<main>
    <div class="title-dashboard">
        <h2>Hor??rios marcados como livre</h2>
    </div>
    <div id='calendar' style="margin-top: 2em;"></div>
    <script>

    </script>
</main>
<%@include file="/views/includes/footer.jsp" %>
<%@include file="/views/includes/scripts-js.jsp" %>

</body>
</html>