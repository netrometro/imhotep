times = []
let dados =""
$.ajax({
    url: "<%= request.getContextPath()%>/logged/doctor/gettimes",
    type: "post",
    data: dados,
    dataType: 'json',
    success: function(json){
        let arr = $.map(json, function(el) { return el; })
        console.log(arr);

        for(value of arr){
            times.push({

                    title: 'Repeating Evnt',
                    start: value,
                    data: value,
                }
            )
        }

        console.log(times);

    },
    error: function(){
        msg.text("Erro ao fazer requisição");
    }
});
console.log(times.responseJSON)
$(document).ready(function() {

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

        events: {
            success: function (json){
                var data = moment(json);
                let arr = $.map(json, function(el) { return el; })
                console.log(arr);

                for(value of arr){
                    times.push({

                            title: 'Repeating Evnt',
                            start: value,
                        }
                    )
                }
            },
        },
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
