package br.upe.model.entities;

import br.upe.service.core.Column;
import br.upe.service.core.Table;

@Table(name="user_role")
public class UserRole {

    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

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
