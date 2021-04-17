package br.upe.controllers;
import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.DatabaseContext;
import br.upe.service.DatabaseUtils;

@WebServlet("/install")
public class InstallController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InstallController(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DatabaseContext dbContext = DatabaseUtils.getDatabaseContext();
            dbContext.ensureDeletedDatabase();
            dbContext.getUserRoles().Create(new UserRole(1, "doctor"));
            //dbContext.getUsers().Create(new User(1, String name, String email, String cpf, String birthday, String password, String crm, int userRoleId));
            response.getWriter().append("Database Deleted\n");
            dbContext.ensureCreatedDatabase();
            response.getWriter().append("Database Created");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            response.getWriter().append(e.getMessage());
        }
    }    
}
