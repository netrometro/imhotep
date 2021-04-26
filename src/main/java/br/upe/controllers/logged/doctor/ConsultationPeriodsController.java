package br.upe.controllers.logged.doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.model.entities.ConsultationPeriods;

@WebServlet(name = "/consultation-periods", urlPatterns = "/logged/doctor/consultation-periods.jsp")
public class ConsultationPeriodsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/logged/dashboards/consultation-periods.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConsultationPeriods consultationPeriods = new ConsultationPeriods();
        //consultationPeriods.setId(request.getSession().getAttribute("userlogged"));
        request.getRequestDispatcher("/views/logged/dashboards/dashboard-doctor.jsp").forward(request, response);
    }
}
