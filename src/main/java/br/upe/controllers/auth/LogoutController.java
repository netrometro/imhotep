package br.upe.controllers.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logout", urlPatterns = {"/logout.jsp"})
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogoutController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        session.invalidate();

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
