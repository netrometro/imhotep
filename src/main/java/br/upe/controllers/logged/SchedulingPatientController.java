package br.upe.controllers.logged;

import br.upe.controllers.auth.LoginController;
import br.upe.model.entities.ConsultationEntity;
import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.DatabaseContext;
import br.upe.util.DatabaseUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/scheduling-doctor", urlPatterns = {"/logged/patient/scheduling-doctor.jsp"})
public class SchedulingPatientController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();

    public SchedulingPatientController() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idDoctor = request.getParameter("id");
        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
        User doctor = dbContext.getUsers().Find("id", idDoctor);
        request.setAttribute("doctor", doctor);

        List<ConsultationEntity> consuls = dbContext.getConsultations().ToArray();
        ArrayList<Consultation> times = new ArrayList<>();

        for(int i=0; i<consuls.size(); i++){
            if(!doctor.getCrm().equals(consuls.get(i).getUserCrm())) continue;
            times.add(new Consultation(consuls.get(i), consuls.get(i).getDate().toString()));
        }

        String json = this.gson.toJson(times);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.print(json);
        out.flush();


        request.getRequestDispatcher("/views/logged/dashboards/scheduling-doctor.jsp").forward(request, response);
    }
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            doGet(request, response);
        }

        private class Consultation extends ConsultationEntity implements Serializable {

            private String dateString = "";

            public Consultation(ConsultationEntity c, String datestring) {
                super(c.getId(), c.getPeriod(), c.getDate(), c.getUserCrm());
                this.dateString = datestring;
            }
        }
    }


