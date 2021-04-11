package br.upe.controllers.auth;

import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.DatabaseContext;
import br.upe.service.core.DbSet;
import br.upe.util.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
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
        String senha = request.getParameter("senha");

        if (login == null || login.isEmpty()) {
            erros.add("Login não informado!");
        }
        if (senha == null || senha.isEmpty()) {
            erros.add("Senha não informada!");
        }

        if (erros.size() == 0) {

            try {
                Class.forName("org.postgresql.Driver");
                Connection conn = DriverManager.getConnection( DBUtils.url(), DBUtils.userName(), DBUtils.password());

                DatabaseContext dbContext = new DatabaseContext(conn);

                DbSet<User> dao = new DbSet<User>(conn, User.class);
                User user = dao.FindByField("cpf", "'" + login + "'");

                System.out.println("User from DB: "+user.toString() );
                if (user != null) {
                    if (user.getPassword().equalsIgnoreCase(senha)) {
                        request.getSession().setAttribute("userlogged", user);
                        response.sendRedirect("index.jsp");
                        return;
                    } else {
                        erros.add("Senha inválida!");
                    }
                } else {
                    erros.add("Usuário não encontrado!");
                }

            } catch (Exception e) {

            }

        }

        request.getSession().invalidate();
        request.setAttribute("mensagens", erros);

        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }
}
