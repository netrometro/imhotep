package br.upe.controllers;

import br.upe.model.entities.ConsultationEntity;
import br.upe.model.entities.User;
import br.upe.service.DatabaseContext;
import br.upe.util.DatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setCpf(request.getParameter("cpf"));
        user.setPassword(request.getParameter("password"));
        // will have to be changed when other user are allowed to register
        String checkDoctor = request.getParameter("check-doctor");
        String checkEmployee = request.getParameter("check-employee");
        if (checkDoctor != null) {
            System.out.println("doctor");
            user.setUserRoleId(1);
            user.setCrm(request.getParameter("crm"));
        } else if (checkEmployee != null) {
            System.out.println("employee");
            user.setCrm(request.getParameter("crm"));
            user.setUserRoleId(2);

        } else {
            user.setUserRoleId(3);
            user.setCrm(user.getId()+"" );
        }

        user.setBirthday(request.getParameter("birthday"));

        DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
        User soughtUser;
        if (checkDoctor != null || checkEmployee != null) {
            soughtUser = dbContext.getUsers().Find("crm", user.getCrm());
        } else {
            soughtUser = dbContext.getUsers().Find("cpf", user.getCpf());
        }

        if (soughtUser == null) {
            User createdUser = dbContext.getUsers().Create(user);
            if(!createdUser.getCrm().equals("") || createdUser.getCrm() != null) {
                dbContext.getUsers().Create(user);
            }
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("registration");
        }
    }
}
