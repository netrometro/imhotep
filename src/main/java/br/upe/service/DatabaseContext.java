package br.upe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.upe.model.entities.ConsultationPeriods;
import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.core.DbSet;
import br.upe.service.core.IDbSet;

public class DatabaseContext {
    private Connection conn;
    private IDbSet<UserRole> userRoles;
    private IDbSet<User> users;
    private IDbSet<ConsultationPeriods> consultationPeriods;

    public DatabaseContext(Connection databaseConnection){        
        conn = databaseConnection;
        userRoles = new DbSet<UserRole>(databaseConnection, UserRole.class);
        users = new DbSet<User>(databaseConnection, User.class);
    }

    public IDbSet<ConsultationPeriods> getConsultationPeriods() {
        return consultationPeriods;
    }

    public void setConsultationPeriods(IDbSet<ConsultationPeriods> consultationPeriods) {
        this.consultationPeriods = consultationPeriods;
    }

    public IDbSet<UserRole> getUserRoles() {
        return userRoles;
    }

    public IDbSet<User> getUsers() {
        return users;
    }

    /**
     * Create database if it doesn't exists
     * @throws SQLExceptionif(request.getParameter("crm") != null){
            user.setUserRoleId(1);
        }else{
            user.setUserRoleId(0);
        }
        user.setUserRoleId(1);
     */
    public void ensureCreatedDatabase() throws SQLException{
        Statement st =  conn.createStatement();
        String command = "BEGIN; CREATE TABLE user_roles (id serial PRIMARY KEY, name varchar(20) NOT NULL); CREATE TABLE users (id serial PRIMARY KEY, name varchar(100) NOT NULL" +
                         ", email varchar NOT NULL, cpf varchar(11) NOT NULL, birthday date NOT NULL, password varchar NOT NULL, crm varchar, user_role_id integer, CONSTRAINT " +
                         "fk_user_role FOREIGN KEY(user_role_id) REFERENCES user_roles(id));" +
                         "CREATE TABLE consultation_periods (id serial PRIMARY KEY, sunday varchar, monday varchar, tuesday varchar, wednesday varchar," +
                         " thursday varchar, friday varchar, saturday varchar, CONSTRAINT fk_user FOREIGN KEY(id) REFERENCES users(id));" + 
                         "INSERT INTO user_roles(name) values('"+UserRole.DOCTOR+"');" +
                         "INSERT INTO user_roles(name) values('"+UserRole.EMPLOYEER+"');" +
                         "INSERT INTO user_roles(name) values('"+UserRole.PATIENT+"');" +
                         "END TRANSACTION;";
        st.execute(command);
        st.execute("COMMIT;");
    }

    public void ensureDeletedDatabase() throws SQLException {
        Statement st = conn.createStatement();
        String command = "BEGIN; DROP TABLE IF EXISTS consultation_periods; DROP TABLE IF EXISTS users; END TRANSACTION; DROP TABLE IF EXISTS user_roles;";
        st.execute(command);
        st.execute("COMMIT;");
    }
}
