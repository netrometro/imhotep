package br.upe.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    public static DatabaseContext getDatabaseContext(String databaseUrl){
        URI dbUri;
        try {
            dbUri = new URI(databaseUrl);
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection( dbUrl, username, password);
            DatabaseContext dbContext = new DatabaseContext(conn);
            return dbContext;
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static DatabaseContext getDatabaseContext(){
        return getDatabaseContext(System.getenv("DATABASE_URL"));
    }
}
