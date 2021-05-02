package br.upe.controllers.logged.doctor;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.controllers.auth.LoginController;
import br.upe.model.entities.ConsultationEntity;
import br.upe.model.entities.User;
import br.upe.service.DatabaseContext;
import br.upe.util.DatabaseUtils;

@WebServlet(name = "/consultation-periods", urlPatterns = "/logged/doctor/consultation-periods.jsp")
public class ConsultationPeriodsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/logged/dashboards/consultation-periods.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConsultationEntity consultationPeriods = new ConsultationEntity();
        User sessionUser = (User) request.getSession().getAttribute(LoginController.USER_LOGGED_ATTRIBUTE_NAME);
        consultationPeriods.setUserCrm(sessionUser.getCrm());
        consultationPeriods.setDate(Date.valueOf(request.getParameter("date")));
        consultationPeriods.setPeriod(request.getParameter("period"));

        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
        if (((ConsultationEntity) dbContext.getConsultations().Find(consultationPeriods.getId())) != null) {
            dbContext.getConsultations().update(consultationPeriods);
        }else {
            dbContext.getConsultations().Create(consultationPeriods);
        }
        request.getRequestDispatcher("/views/logged/dashboards/dashboard-doctor.jsp").forward(request, response);
    }
}
