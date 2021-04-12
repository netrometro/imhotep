package br.upe.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.model.entities.User;
import br.upe.service.DatabaseContext;
import br.upe.service.DatabaseUtils;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/views/registration.jsp").forward(request, response);;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = new User();

        user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setCpf(request.getParameter("cpf"));
		user.setPassword(request.getParameter("password"));
        // will have to be changed when other user are allowed to register
		user.setUserRoleId(1);
		user.setBirthday(request.getParameter("birthday"));
        user.setCrm(request.getParameter("crm"));

        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();

        if (dbContext.getUsers().Find("cpf", user.getCpf()) == null && dbContext.getUsers().Find("crm", user.getCrm()) == null){
            dbContext.getUsers().Create(user);
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("registration");
        }
    }
}
