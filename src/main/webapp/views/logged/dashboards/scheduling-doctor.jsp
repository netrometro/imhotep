<%@include file="/views/includes/start.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'/>

    <link href="<%= request.getContextPath()%>/resources/css/calendar/fullcalendar.css" rel="stylesheet"/>
    <link href="<%= request.getContextPath()%>/resources/css/calendar/stylecalendar.css" rel="stylesheet"/>
    <link href="<%= request.getContextPath()%>/resources/css/calendar/fullcalendar.print.min.css" rel='stylesheet' media='print'/>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/moment.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/jquery.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/fullcalendar.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/language/pt-br.js"></script>
    <br>
    <script>
        times = []
        let dados = ""
        $.ajax({
            url: "<%= request.getContextPath()%>/logged/patient/scheduling-doctor",
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

</head>
<body>

<div id='calendar'></div>


<%@include file="/views/includes/end.jsp" %>

