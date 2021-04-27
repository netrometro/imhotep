package br.upe.controllers;

import br.upe.model.entities.ConsultationPeriods;
import br.upe.model.entities.User;
import br.upe.service.DatabaseContext;
import br.upe.util.DatabaseUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/install")
public class InstallController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InstallController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
            dbContext.ensureDeletedDatabase();
            response.getWriter().append("Database Deleted\n");
            dbContext.ensureCreatedDatabase();
            response.getWriter().append("Database Created");

            createDoctorTest(dbContext);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            response.getWriter().append(e.getMessage());
        }
    }

    private void createDoctorTest(DatabaseContext dbContext) {
        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(agora);

        User user = new User(1, "medico1", "medico1@emial.com", "300200100", dataFormatada, "111", "100200300", 1);
        user = dbContext.getUsers().Create(user);

        createFakeTimes(dbContext);
    }

    private void createFakeTimes(DatabaseContext dbContext) {
        ConsultationPeriods nextWeek = generateWeekOfTimes(new int[]{3, 4, 1});
        ConsultationPeriods currentWeek = generateWeekOfTimes(new int[]{3, 4, 1});
        ConsultationPeriods lastWeek = generateWeekOfTimes(new int[]{5, 7, 2});

        //dbContext.getConsultationPeriods().Create(nextWeek);
        dbContext.getConsultationPeriods().Create(currentWeek);
        //.getConsultationPeriods().Create(lastWeek);
    }

    private ConsultationPeriods generateWeekOfTimes(int[] hours) {
        ConsultationPeriods week = new ConsultationPeriods();
        week.setId(1);
        week.setFriday(
                LocalDateTime.now().plusHours(hours[0]).plusMinutes(0).format(DateTimeFormatter.ofPattern("HH:mm")) + ";" +
                        LocalDateTime.now().plusHours(hours[0]).plusMinutes(30).format(DateTimeFormatter.ofPattern("HH:mm")));
        week.setThursday(
                LocalDateTime.now().plusHours(hours[1]).plusMinutes(0).format(DateTimeFormatter.ofPattern("HH:mm")) + ";" +
                        LocalDateTime.now().plusHours(hours[1]).plusMinutes(30).format(DateTimeFormatter.ofPattern("HH:mm")));
        week.setTuesday(
                LocalDateTime.now().plusHours(hours[2]).minusHours(0).format(DateTimeFormatter.ofPattern("HH:mm")) + ";" +
                        LocalDateTime.now().plusHours(hours[2]).minusHours(30).format(DateTimeFormatter.ofPattern("HH:mm")));
        return week;
    }
}
