<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ page import="br.upe.model.entities.User" %>
    <% User doctor = (User) request.getAttribute("doctor"); %>
    <%@include file="/views/includes/links-css.jsp" %>
    <script>
        times = []
        let dados = ""
        $.ajax({
            url: "<%= request.getContextPath()%>/logged/patient/scheduling-doctor.jsp?crm=" +<%= doctor.getCrm() %>,
            type: "get",
            data: dados,
            dataType: 'json',
            success: function (json) {
                let arr = $.map(json, function (el) {
                    return el;
                })

                console.log("Antes: ", arr)
                let eColor = "#c7dfda"

                for (value of arr) {
                    const t = value.period.split("-");
                    let iduser = null;
                    eColor = "#c7dfda"
                    if (value.idPatient) {
                        iduser = value.idPatient;
                        eColor = "#E97F7F";
                    }
                    times.push({
                        title: value.period,
                        start: value.dateString + "T" + t[0],
                        end: value.dateString + "T" + t[1],

                        //se o horario estiver agendado criar isso abaixo
                        idPatient: iduser,
                        //namePatient: "",
                        idConsultation: value.id,
                        color: eColor,
                    });
                }

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
                        eventClick: function (info) {
                            if(info.color != "#E97F7F"){
                                if (info.idConsultation) {
                                    $.ajax({
                                        url: "<%= request.getContextPath()%>/logged/patient/addnewtime",
                                        type: 'post',
                                        data: {
                                            idconsultation: info.idConsultation,
                                            crmDoctor: <%= doctor.getCrm() %>,
                                        },
                                    });
                                    alert("Agendamento realizado com sucesso!")

                                }
                            }else {
                                alert("Esse horário já está reservado por outra pessoa")
                            }
                        },
                    });
                });
            },
            error: function () {
                msg.text("Erro ao fazer requisição");
            }
        });
    </script>

    <title>Horários</title>
</head>
<body>
<%@include file="/views/includes/navbar.jsp" %>
<main>

    <div id='calendar'></div>

    Informações sobre o médico:
    <%= doctor.getName() %>
</main>
<%@include file="/views/includes/footer.jsp" %>
<%@include file="/views/includes/scripts-js.jsp" %>
</body>
</html>




