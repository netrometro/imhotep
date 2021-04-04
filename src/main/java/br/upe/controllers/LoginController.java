package br.upe.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.dao.UserDAO;
import br.upe.models.User;

@WebServlet(name = "/login", urlPatterns = {"/login.jsp"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginController() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        ArrayList<String> erros = new ArrayList<String>();
        System.out.println("middlerewes login");
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
                UserDAO dao = new UserDAO();
                User user = dao.getSingle(login);
                System.out.println(user.toString());
                if (user != null) {
                    if (user.getPassword().equalsIgnoreCase(senha)) {
                        request.getSession().setAttribute("usuarioLogado", user);
                        response.sendRedirect("logado/menu.jsp");
                        return;
                    } else {
                        erros.add("Senha inválida!");
                    }
                } else {
                    erros.add("Usuário não encontrado!");
                }
            }

        }
        request.getSession().invalidate();


        request.setAttribute("mensagens", erros);

        String URL = "/WEB-INF/view/index.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(URL);
        rd.forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("login get");
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	
	}

}
