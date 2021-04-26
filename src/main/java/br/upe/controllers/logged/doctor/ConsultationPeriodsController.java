package br.upe.controllers.logged.doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.controllers.auth.LoginController;
import br.upe.model.entities.ConsultationPeriods;
import br.upe.model.entities.User;
import br.upe.service.DatabaseContext;
import br.upe.service.DatabaseUtils;

@WebServlet(name = "/consultation-periods", urlPatterns = "/logged/doctor/consultation-periods.jsp")
public class ConsultationPeriodsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/logged/dashboards/consultation-periods.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConsultationPeriods consultationPeriods = new ConsultationPeriods();
        User sessionUser = (User) request.getSession().getAttribute(LoginController.USER_LOGGED_ATTRIBUTE_NAME);
        consultationPeriods.setId(sessionUser.getId());
        consultationPeriods.setFriday(request.getParameter("friday"));
        consultationPeriods.setMonday(request.getParameter("monday"));
        consultationPeriods.setSaturday(request.getParameter("saturday"));
        consultationPeriods.setThursday(request.getParameter("thursday"));
        consultationPeriods.setTuesday(request.getParameter("tuesday"));
        consultationPeriods.setWednesday(request.getParameter("wednesday"));
        consultationPeriods.setSunday(request.getParameter("sunday"));

        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
        if (((ConsultationPeriods) dbContext.getConsultationPeriods().Find(consultationPeriods.getId())) != null) {
            dbContext.getConsultationPeriods().update(consultationPeriods);
        }else {
            dbContext.getConsultationPeriods().Create(consultationPeriods);
        }
        request.getRequestDispatcher("/views/logged/dashboards/dashboard-doctor.jsp").forward(request, response);
    }
}
