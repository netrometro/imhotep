package br.upe.controllers.logged.patient;

import br.upe.model.entities.ConsultationEntity;
import br.upe.model.entities.User;
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

import java.io.Serializable;

@WebServlet(name = "/scheduling-settime", urlPatterns = {"/logged/patient/scheduling-settime"})
public class SchedulingTimeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();

    public SchedulingTimeController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User u = (User) session.getAttribute("userlogged");
        String idconsultation = request.getParameter("idconsultation");
        System.out.println("id da consulta :"+ idconsultation);

        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
        ConsultationEntity c = dbContext.getConsultations().Find("id", idconsultation);
        c.setIdPatient(u.getId());

        dbContext.getConsultations().update(c);
        response.sendRedirect("/logged/patient/scheduling-doctor.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("/logged/patient/scheduling-doctor.jsp");
    }

    private class Consultation extends ConsultationEntity implements Serializable {

        private String dateString = "";

        public Consultation(ConsultationEntity c, String datestring) {
            super(c.getId(), c.getPeriod(), c.getDate(), c.getUserCrm(), c.getIdPatient());
            this.dateString = datestring;
        }
    }
}