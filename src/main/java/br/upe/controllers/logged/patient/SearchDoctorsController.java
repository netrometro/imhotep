package br.upe.controllers.logged.patient;

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

import com.google.gson.Gson;

import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.DatabaseContext;
import br.upe.util.DatabaseUtils;

@WebServlet(name = "/search-doctors", urlPatterns = {"/logged/patient/search-doctors.jsp"})
public class SearchDoctorsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();

    public SearchDoctorsController() {
        super();
    }

      protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
        String query = req.getParameter("specialties");
        List<User> users;
        if (query != null && !query.equals("")) {
            users = dbContext.getUsersDbSet().FindDoctorsThatContainspartialSpecialtyName(query);
        }else {
            users = dbContext.getUsersDbSet().FindAll("user_role_id", 1);
        }

        req.setAttribute("doctors", users);

        req.getRequestDispatcher("/views/logged/dashboards/search-doctors.jsp").forward(req, res);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    /*private class Consultation extends ConsultationEntity implements Serializable {

        private String dateString = "";

        public Consultation(ConsultationEntity c, String datestring) {
            super(c.getId(), c.getPeriod(), c.getDate(), c.getUserCrm());
            this.dateString = datestring;
        }
    }*/
}