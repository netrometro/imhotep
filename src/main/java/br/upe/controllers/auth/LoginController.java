package br.upe.controllers.auth;

import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.DatabaseContext;
import br.upe.service.DatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "/login", urlPatterns = {"/login.jsp"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, URISyntaxException, SQLException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<String> erros = new ArrayList<String>();

        String login = request.getParameter("login");
        String senha = request.getParameter("password");

        if (login == null || login.isEmpty()) {
            erros.add("Login não informado!");
        }
        if (senha == null || senha.isEmpty()) {
            erros.add("Senha não informada!");
        }

        if (erros.size() == 0) {
            try {
                DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
                User user = dbContext.getUsers().Find("cpf", login);
                System.out.println("Usuario logado " + user);
                if (user != null) {
                    if (user.getPassword().equalsIgnoreCase(senha)) {
                        request.getSession().setAttribute("userlogged", user);

                        //System.out.println("O erro foi: "+user.toString());
                        DatabaseContext dbContext2 = DatabaseUtils.getDatabaseContext();
                        UserRole userRole = dbContext2.getUserRoles().Find(user.getUserRoleId());
                        //System.out.println("uerRole "+userRole.toString());
                        if(userRole.getName().equalsIgnoreCase(UserRole.DOCTOR)){
                            response.sendRedirect("logged/doctor/dashboard-doctor.jsp");
                            return;
                        }else if(userRole.getName().equalsIgnoreCase(UserRole.EMPLOYEER)){
                            response.sendRedirect("logged/employee/dashboard-employee.jsp");
                            return;
                        }else if(userRole.getName().equalsIgnoreCase(UserRole.PATIENT)){
                            response.sendRedirect("logged/patient/dashboard-patient.jsp");
                            return;
                        }

                        response.sendRedirect("index.jsp");
                        return;
                    } else {
                        erros.add("Senha inválida!");
                    }
                } else {
                    erros.add("Usuário não encontrado!");
                }

            } catch (Exception e) {
                System.out.println("O erro foi: "+e);
            }
        }

        request.getSession().invalidate();
        request.setAttribute("mensagens", erros);

        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }
}
