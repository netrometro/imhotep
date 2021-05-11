<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <%@include file="/views/includes/links-css.jsp" %>
    <script>

        $(document).ready(function() {

            $('#calendar').fullCalendar({
                header: {
                    center: 'month,agendaWeek,agendaDay,listWeek',
                    right: 'today, prev,next, addEventButton',
                    left: 'title',
                },
                defaultDate: Date(),
                navLinks: true, // can click day/week names to navigate views
                editable: true,
                eventLimit: true, // allow "more" link when too many events
                events: [
                    {
                        title: 'All Day Event',
                        start: '2018-03-01',
                    },
                    {
                        title: 'Long Event',
                        start: '2018-03-07',
                        end: '2018-03-10'
                    },
                    {
                        id: 999,
                        title: 'Repeating Event',
                        start: '2018-03-09T16:00:00'
                    },
                    {
                        id: 999,
                        title: 'Repeating Event',
                        start: '2018-03-16T16:00:00'
                    },
                    {
                        title: 'Conference',
                        start: '2018-03-11',
                        end: '2018-03-13'
                    },
                    {
                        title: 'Meeting',
                        start: '2018-03-12T10:30:00',
                        end: '2018-03-12T12:30:00'
                    },
                    {
                        title: 'Lunch',
                        start: '2018-03-12T12:00:00'
                    },
                    {
                        title: 'Meeting',
                        start: '2018-03-12T14:30:00'
                    },
                    {
                        title: 'Happy Hour',
                        start: '2018-03-12T17:30:00'
                    },
                    {
                        title: 'Dinner',
                        start: '2018-03-12T20:00:00'
                    },
                    {
                        title: 'Birthday Party',
                        start: '2018-03-13T07:00:00'
                    },
                    {
                        title: 'Click for Google',
                        url: 'http://google.com/',
                        start: '2018-03-28'
                    }
                ],
                customButtons: {
                    addEventButton: {
                        text: 'Add new event',
                        click: function () {
                            var dateStr = prompt('Enter date in YYYY-MM-DD format');
                            var date = moment(dateStr);

                            if (date.isValid()) {
                                $('#calendar').fullCalendar('renderEvent', {
                                    title: 'Dynamic event',
                                    start: date,
                                    allDay: true
                                });
                            } else {
                                alert('Invalid Date');
                            }

                        }
                    }
                },
                dayClick: function (date, jsEvent, view) {
                    var date = moment(date);

                    if (date.isValid()) {
                        $('#calendar').fullCalendar('renderEvent', {
                            title: 'Dynamic event from date click',
                            start: date,
                            allDay: true
                        });
                    } else {
                        alert('Invalid');
                    }
                },
            });

        });

    </script>

    <title>Horários</title>
</head>
<body>
<%@include file="/views/includes/navbar.jsp" %>
<main>

    <div id='calendar'></div>

</main>
<%@include file="/views/includes/footer.jsp" %>
<%@include file="/views/includes/scripts-js.jsp" %>
<%@include file="/views/includes/scripts-js.jsp" %>
</body>
</html>




