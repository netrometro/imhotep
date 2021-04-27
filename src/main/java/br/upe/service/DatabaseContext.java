package br.upe.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.upe.model.entities.ConsultationPeriods;
import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;
import br.upe.service.core.DbSet;
import br.upe.service.core.IDbSet;
import br.upe.util.SqlUtils;

public class DatabaseContext {
    private Connection conn;
    private IDbSet<UserRole> userRoles;
    private IDbSet<User> users;
    private IDbSet<ConsultationPeriods> consultationPeriods;

    public DatabaseContext(Connection databaseConnection){        
        conn = databaseConnection;
        userRoles = new DbSet<UserRole>(databaseConnection, UserRole.class);
        users = new DbSet<User>(databaseConnection, User.class);
        consultationPeriods = new DbSet<ConsultationPeriods>(databaseConnection, ConsultationPeriods.class);
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
     * @throws SQLException if crm == null
     */
    public void ensureCreatedDatabase() throws SQLException{
        Statement st =  conn.createStatement();
        String command = "BEGIN; "+
                SqlUtils.SQL_TABLE_OF_USER_TYPES +
                SqlUtils.SQL_TABLE_OF_USER +
                SqlUtils.SQL_TABLE_OF_CONSULTATION_PERIODS +
                SqlUtils.SQL_STANDARD_USER_TYPES+
                " END TRANSACTION;";

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
