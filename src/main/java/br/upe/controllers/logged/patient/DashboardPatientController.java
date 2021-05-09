package br.upe.controllers.logged.patient;

import br.upe.controllers.logged.doctor.TimesController;
import br.upe.model.entities.ConsultationEntity;
import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.DatabaseContext;
import br.upe.util.DatabaseUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.StreamFilter;

@WebServlet(name = "/dashboard-patient", urlPatterns = {"/logged/patient/dashboard-patient.jsp"})
public class DashboardPatientController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();

    public DashboardPatientController() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User u = (User) session.getAttribute("userlogged");
        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
        List<User> users = dbContext.getUsers().ToArray();
        ArrayList<User> doctors = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            try {
                UserRole Tuser = dbContext.getUserRoles().Find("id", users.get(i).getUserRoleId());
                if (Tuser.getName().equals(UserRole.DOCTOR)) {
                    System.out.println("Medicos " + users.get(i).getName());
                    doctors.add(users.get(i));
                }
            } catch (Exception e) {
                response.sendRedirect("/");
            }
        }
        /*
        User[] mDoctors = new User[doctors.size()];
        for (int i = 0; i < doctors.size(); i++) {
            mDoctors[i] = (User) doctors.get(i);
        }
        */
        request.setAttribute("doctors", doctors);

        request.getRequestDispatcher("/views/logged/dashboards/dashboard-patient.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
