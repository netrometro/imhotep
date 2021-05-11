package br.upe.controllers.logged.doctor;

import br.upe.model.entities.User;
import br.upe.service.DatabaseContext;
import br.upe.util.DatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/view-patient", urlPatterns = {"/logged/doctor/view-patient.jsp"})
public class ViewPatientController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewPatientController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idPatient = request.getParameter("id");
        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
        User patient = dbContext.getUsers().Find("id", idPatient);
        request.setAttribute("patient", patient);

        request.getRequestDispatcher("/views/logged/view-patient.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
