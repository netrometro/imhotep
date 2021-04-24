<%@include file="/views/includes/start.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8' />

    <link href="<%= request.getContextPath()%>/resources/css/calendar/fullcalendar.css" rel="stylesheet"/>
    <link href="<%= request.getContextPath()%>/resources/css/calendar/stylecalendar.css" rel="stylesheet"/>
    <link href="<%= request.getContextPath()%>/resources/css/calendar/fullcalendar.print.min.css" rel='stylesheet' media='print' />
    <script src="<%= request.getContextPath()%>/resources/js/calendar/moment.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/jquery.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/fullcalendar.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/calendar/language/pt-br.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
    <p>
        <script>

            $(document).ready(function() {

                var calendar =  $('#calendar').fullCalendar({
                    header: {
                        left: 'title',
                        center: 'agendaDay,agendaWeek,month',
                        right: 'prev,next today'
                    },
                    defaultDate: Date(),
                    navLinks: true, // can click day/week names to navigate views
                    editable: true,
                    eventLimit: true, // allow "more" link when too many events
                    events: [
                        {
                            title: 'All Day Event',
                            start: '2021-04-01',
                        },
                        {
                            title: 'Long Event',
                            start: '2021-04-07',
                            end: '2021-04-10'
                        },
                        {
                            id: 999,
                            title: 'Repeating Event',
                            start: '2021-04-09T16:00:00'
                        },
                        {
                            id: 999,
                            title: 'Repeating Event',
                            start: '2021-04-16T16:00:00'
                        },
                        {
                            title: 'Conference',
                            start: '2021-04-11',
                            end: '2021-04-13'
                        },
                        {
                            title: 'Meeting',
                            start: '2021-04-12T10:30:00',
                            end: '2021-04-12T12:30:00'
                        },
                        {
                            title: 'Lunch',
                            start: '2021-04-12T12:00:00'
                        },
                        {
                            title: 'Meeting',
                            start: '2021-04-12T14:30:00'
                        },
                        {
                            title: 'Happy Hour',
                            start: '2021-04-12T17:30:00'
                        },
                        {
                            title: 'Dinner',
                            start: '2021-04-12T20:00:00'
                        },
                        {
                            title: 'Birthday Party',
                            start: '2021-04-13T07:00:00'
                        },
                        {
                            title: 'Click for Google',
                            url: 'http://google.com/',
                            start: '2021-04-28'
                        },
                        {
                            title: 'Birthday Rodrigo',
                            start: '2021-04-30T07:00:00'
                        }
                    ]
                });

            });

        </script>
    </p>
</head>
<body>

<div id='wrap'>

    <div id='calendar'></div>

    <div style='clear:both'></div>
</div>

</body>
<%@include file="/views/includes/end.jsp" %>

