package br.upe.util;

import java.net.URI;
import java.net.URISyntaxException;

public class DBUtils {

    public static String url() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        return dbUrl;
    }

    public static String userName() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        String username = dbUri.getUserInfo().split(":")[0];
        return username;
    }

    public static String password() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        String password = dbUri.getUserInfo().split(":")[1];
        return password;
    }
}
