package br.upe.service.core;

import java.sql.Connection;
import java.util.List;

import br.upe.model.entities.User;
import br.upe.model.entities.UserRole;

public class UsersDbSet extends DbSet<User> {

    public UsersDbSet(Connection databaseConnection, Class<User> type) {
        super(databaseConnection, type);
    }

    public List<User> FindDoctorsThatContainspartialSpecialtyName(String partialSpecialty){
        String command = "SELECT * FROM " + tableName + " WHERE user_role_id=" + 1 + " AND (UPPER(specialties) LIKE UPPER('%" + partialSpecialty + "%') OR UPPER(name) LIKE UPPER('%" + partialSpecialty + "%'));";
        return getListFromCommand(command);
    }

}