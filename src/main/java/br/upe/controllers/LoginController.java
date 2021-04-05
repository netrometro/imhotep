package br.upe.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.model.entities.UserRole;
import br.upe.service.DatabaseContext;
import br.upe.service.core.DbSet;

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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("login get");
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

        ArrayList<String> erros = new ArrayList<String>();

        if (request.getParameter("bOK") != null) {
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

                    URI dbUri = new URI(System.getenv("DATABASE_URL"));
                    String username = dbUri.getUserInfo().split(":")[0];
                    String password = dbUri.getUserInfo().split(":")[1];
                    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
                    Class.forName("org.postgresql.Driver");
                    Connection conn = DriverManager.getConnection(dbUrl, username, password);
                    DatabaseContext dbContext = new DatabaseContext(conn);

                    UserRole user = new UserRole();
                    user = dbContext.getUserRoles().FindByField("cpf", login);
                    //UserRole user = new UserRole(1, "ze", "ze@gmail.com", "123");

                    System.out.println("User: "+user.toString());

                    if (user != null) {
                        if (user.getPassword().equalsIgnoreCase(senha)) {
                            request.getSession().setAttribute("userlogged", user);
                            response.sendRedirect("logged/menu.jsp");
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
        }

        request.getSession().invalidate();
        request.setAttribute("mensagens", erros);

        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

}
