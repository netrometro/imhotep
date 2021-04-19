package br.upe.controllers.logged.doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/dashboard-doctor", urlPatterns = {"/logged/doctor/dashboard-doctor.jsp"})
public class DashboardDoctorController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DashboardDoctorController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/logged/dashboards/dashboard-doctor.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
