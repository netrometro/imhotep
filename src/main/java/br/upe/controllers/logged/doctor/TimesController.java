
package br.upe.controllers.logged.doctor;

        import br.upe.model.entities.ConsultationEntity;
        import br.upe.model.entities.User;
        import br.upe.service.DatabaseContext;
        import br.upe.util.DatabaseUtils;
        import com.google.gson.Gson;

        import java.io.IOException;
        import java.io.PrintWriter;
        import java.io.Serializable;
        import java.util.ArrayList;
        import java.util.List;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;

@WebServlet(name = "/gettimes", urlPatterns = {"/logged/doctor/gettimes"})
public class TimesController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();

    public TimesController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User u = (User) session.getAttribute("userlogged");

        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
        List<ConsultationEntity> consuls = dbContext.getConsultations().ToArray();

        ArrayList<Consultation> times = new ArrayList<Consultation>();

        for(int i=0; i<consuls.size(); i++){
            if(!u.getCrm().equals(consuls.get(i).getUserCrm())) continue;
            times.add(new Consultation(consuls.get(i), consuls.get(i).getDate().toString()));
        }

        String json = this.gson.toJson(times);

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

    private class Consultation extends ConsultationEntity implements Serializable {

        private String dateString = "";

        public Consultation(ConsultationEntity c, String datestring) {
            super(c.getId(), c.getPeriod(), c.getDate(), c.getUserCrm(), c.getIdPatient());
            this.dateString = datestring;
        }
    }
}
