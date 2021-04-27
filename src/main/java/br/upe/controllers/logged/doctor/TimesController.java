
package br.upe.controllers.logged.doctor;

        import br.upe.model.entities.ConsultationPeriods;
        import br.upe.model.entities.User;
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
        List<ConsultationPeriods> consuls = dbContext.getConsultationPeriods().ToArray();

        ArrayList<String> times = new ArrayList<>();

        for(int i=0; i<consuls.size(); i++){
            if(!u.getCrm().equals(consuls.get(i).getUserCrm())) continue;
            if(!consuls.get(i).getMonday().equals("")) times.add(consuls.get(i).getMonday());
            if(!consuls.get(i).getTuesday().equals("")) times.add(consuls.get(i).getTuesday());
            if(!consuls.get(i).getWednesday().equals("")) times.add(consuls.get(i).getWednesday());
            if(!consuls.get(i).getThursday().equals("")) times.add(consuls.get(i).getThursday());
            if(!consuls.get(i).getFriday().equals("")) times.add(consuls.get(i).getFriday());
            if(!consuls.get(i).getSaturday().equals("")) times.add(consuls.get(i).getSaturday());
            if(!consuls.get(i).getSunday().equals("")) times.add(consuls.get(i).getSunday());
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
}
