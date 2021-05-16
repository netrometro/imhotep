package br.upe.controllers.logged.patient;

import br.upe.model.entities.ConsultationEntity;
import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.DatabaseContext;
import br.upe.util.DatabaseUtils;
import com.google.gson.Gson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "/addnewtime", urlPatterns = {"/logged/patient/addnewtime"})
public class AddNewTimeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();

    public AddNewTimeController() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/views/logged/dashboards/dashboard-patient.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User u = (User) session.getAttribute("userlogged");

        String idconsultation = request.getParameter("idconsultation");

        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
        ConsultationEntity c = dbContext.getConsultations().Find("id", idconsultation);
        c.setIdPatient(u.getId());

        dbContext.getConsultations().update(c);
        response.sendRedirect("/logged/patient/scheduling-doctor.jsp?id=");

        request.getRequestDispatcher("/views/logged/dashboards/dashboard-patient.jsp").forward(request, response);
    }
}