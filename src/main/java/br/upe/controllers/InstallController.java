package br.upe.controllers;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.upe.model.entities.UserRole;

import br.upe.service.DatabaseContext;
import br.upe.service.core.DbSet;

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
            URI dbUri = new URI(System.getenv("DATABASE_URL"));
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            DatabaseContext dbContext = new DatabaseContext(conn);
            dbContext.ensureDeletedDatabase();
            response.getWriter().append("Database Deleted\n");
            dbContext.ensureCreatedDatabase();
            response.getWriter().append("Database Created");/*
            UserRole userRole = new UserRole();
            userRole.setName("AHAHAHAHAH");
            userRole = dbContext.getUserRoles().Create(userRole);
            userRole.setName("Something else");
            dbContext.getUserRoles().Create(userRole);
            UserRole user =  dbContext.getUserRoles().ToArray().get(1);
            response.getWriter().append(user.getName());
            response.getWriter().append(dbContext.getUserRoles().ToArray().get(0).getName());
            userRole.setName("Changed");
            dbContext.getUserRoles().update(userRole);
            response.getWriter().append(dbContext.getUserRoles().Find(userRole.getId()).getName());
            dbContext.getUserRoles().Delete(userRole.getId());*/
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            response.getWriter().append(e.getMessage());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            response.getWriter().append(e.getMessage());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            response.getWriter().append(e.getMessage());
        }
    }    
}
