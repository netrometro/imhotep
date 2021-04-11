package br.upe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.core.DbSet;
import br.upe.service.core.IDbSet;

public class DatabaseContext {
    private Connection conn;
    private IDbSet<UserRole> userRoles;
    private IDbSet<User> users;

    public DatabaseContext(Connection databaseConnection){        
        conn = databaseConnection;
        userRoles = new DbSet<UserRole>(databaseConnection, UserRole.class);
        users = new DbSet<User>(databaseConnection, User.class);
    }

    public IDbSet<UserRole> getUserRoles() {
        return userRoles;
    }

    public IDbSet<User> getUsers() {
        return users;
    }

    /**
     * Create database if it doesn't exists
     * @throws SQLException
     */
    public void ensureCreatedDatabase() throws SQLException{
        Statement st =  conn.createStatement();
        String command = "BEGIN; CREATE TABLE user_roles (id serial PRIMARY KEY, name varchar(20) NOT NULL); CREATE TABLE users (id serial PRIMARY KEY, name varchar(100) NOT NULL" +
                         ", email varchar NOT NULL, cpf varchar(11) NOT NULL, birthday date NOT NULL, password varchar NOT NULL, crm varchar, user_role_id integer, CONSTRAINT " +
                         "fk_user_role FOREIGN KEY(user_role_id) REFERENCES user_roles(id)); END TRANSACTION;";
        st.execute(command);
        st.execute("COMMIT;");
    }

    public void ensureDeletedDatabase() throws SQLException {
        Statement st = conn.createStatement();
        String command = "BEGIN; DROP TABLE users; DROP TABLE user_roles; END TRANSACTION;";
        st.execute(command);
        st.execute("COMMIT;");
    }
}
