package br.upe.util;

import br.upe.model.entities.UserRole;

public class SqlUtils {

    public static final String SQL_TABLE_OF_USER_TYPES = "CREATE TABLE user_roles (id serial PRIMARY KEY, name varchar(20) NOT NULL);";

    public static String SQL_TABLE_OF_USER = "CREATE TABLE users ( " +
                "id serial PRIMARY KEY, " +
                "name varchar(100) NOT NULL, " +
                "email varchar NOT NULL, " +
                "cpf varchar(11) NOT NULL, " +
                "birthday date NOT NULL, " +
                "password varchar NOT NULL, " +
                "crm varchar, " +
                "user_role_id integer, " +
                "CONSTRAINT fk_user_role FOREIGN KEY(user_role_id) REFERENCES user_roles(id));";

    public static final String SQL_TABLE_OF_CONSULTATION_PERIODS = "CREATE TABLE consultation_periods (" +
                "id serial PRIMARY KEY, " +
                "sunday varchar, " +
                "monday varchar, " +
                "tuesday varchar, " +
                "wednesday varchar, " +
                "thursday varchar, " +
                "friday varchar, " +
                "saturday varchar, " +
                "CONSTRAINT fk_user FOREIGN KEY(id) REFERENCES users(id));";


    public static final String SQL_STANDARD_USER_TYPES = "INSERT INTO user_roles(name) values('" + UserRole.DOCTOR + "');" +
                "INSERT INTO user_roles(name) values('" + UserRole.EMPLOYEER + "');" +
                "INSERT INTO user_roles(name) values('" + UserRole.PATIENT + "');";

}
