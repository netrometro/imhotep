package br.upe.controllers;
import java.io.IOException;

import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            response.getWriter().append("Database Deleted\n");
            dbContext.ensureCreatedDatabase();
            response.getWriter().append("Database Created");

            /* example
            UserRole userRole = new UserRole(1, UserRole.DOCTOR);
            userRole = dbContext.getUserRoles().Create(userRole);
            */

            /* example
            User user = new User(1, "teste", "teste@email.com", "100200300","12-10-2023", "teste123" , "123123123", 1);
            user = dbContext.getUsers().Create(user);
            */

            /*
            userRole = dbContext.getUserRoles().Create(userRole);
            userRole.setName("Something else");
            dserRole user =  dbContext.getUserRoles().ToArray().get(1);
            responsbContext.getUserRoles().Create(userRole);
            Ue.getWriter().append(user.getName());
            response.getWriter().append(dbContext.getUserRoles().ToArray().get(0).getName());
            userRole.setName("Changed");
            dbContext.getUserRoles().update(userRole);
            response.getWriter().append(dbContext.getUserRoles().Find(userRole.getId()).getName());
            dbContext.getUserRoles().Delete(userRole.getId());
            */

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            response.getWriter().append(e.getMessage());
        }
    }    
}
