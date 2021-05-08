
package br.upe.controllers.logged.patient;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/getdoctor", urlPatterns = {"/logged/patient/getdoctor"})
public class DoctorController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();

    public DoctorController() {
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


        ArrayList<String> doctor = new ArrayList<>();

        for(int i=0; i<users.size(); i++){
            try{
                UserRole Tuser = dbContext.getUserRoles().Find("id", users.get(i).getUserRoleId());
                if(Tuser.getName().equals(UserRole.DOCTOR) ){
                    System.out.println("Medicos " + users.get(i).getName());
                    doctor.add(users.get(i).getName());
                }
            }catch (Exception e){
                response.sendRedirect("/");

            }


        }

        String json = this.gson.toJson(doctor);
        System.out.println(json);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.print(json);
        out.flush();
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
