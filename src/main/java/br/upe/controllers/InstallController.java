package br.upe.controllers;

import br.upe.model.entities.ConsultationEntity;
import br.upe.model.entities.User;
import br.upe.service.DatabaseContext;
import br.upe.util.DatabaseUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/install")
public class InstallController extends HttpServlet {

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

        User user = new User(1, "medico1", "medico1@emial.com", "300200100", dataFormatada, "111", "300200100", 1);
        user = dbContext.getUsers().Create(user);

        createFakeTimes(dbContext);
    }

    private void createFakeTimes(DatabaseContext dbContext) {
        ConsultationEntity nextWeek = generateWeekOfTimes(new int[]{3, 4, 1}, 6);
        ConsultationEntity currentWeek = generateWeekOfTimes(new int[]{3, 4, 1}, 1);
        ConsultationEntity lastWeek = generateWeekOfTimes(new int[]{5, 7, 2}, -6);

        nextWeek.setDate(Date.valueOf(LocalDateTime.now().plusDays(7).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        currentWeek.setDate(Date.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        lastWeek.setDate(Date.valueOf(LocalDateTime.now().minusDays(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

        dbContext.getConsultations().Create(nextWeek);
        dbContext.getConsultations().Create(currentWeek);
        dbContext.getConsultations().Create(lastWeek);
    }

    private ConsultationEntity generateWeekOfTimes(int[] hours, int days) {
        ConsultationEntity week = new ConsultationEntity();
        week.setUserCrm("300200100");
        week.setPeriod(generateTimesAdd(hours[1], days));
        return week;
    }

    private String generateTimesAdd(int hrs, int days){
        String strLocalTime2   = ""+
                LocalDateTime.now().plusDays(days).plusHours(hrs).minusHours(0).format(DateTimeFormatter.ofPattern("HH:mm")) + "-" +
                LocalDateTime.now().plusDays(days).plusHours(hrs).minusHours(30).format(DateTimeFormatter.ofPattern("HH:mm"));
        return strLocalTime2;
    }

    private String generateTimesMinus(int hrs, int days){
        String strLocalTime2   = ""+
                LocalDateTime.now().minusDays(days).plusHours(hrs).minusHours(0).format(DateTimeFormatter.ofPattern("HH:mm")) + "-" +
                LocalDateTime.now().minusDays(days).plusHours(hrs).minusHours(30).format(DateTimeFormatter.ofPattern("HH:mm"));
        return strLocalTime2;
    }
}
