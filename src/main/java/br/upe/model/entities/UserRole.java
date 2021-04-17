package br.upe.model.entities;

import br.upe.service.core.Column;
import br.upe.service.core.Table;

@Table(name="user_roles")
public class UserRole {

    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    //public static final String DOCTOR = "doctor";
    //public static final String EMPLOYEER = "employee";
   // public static final String PATIENT = "patient";

    public UserRole(){}

    public UserRole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
