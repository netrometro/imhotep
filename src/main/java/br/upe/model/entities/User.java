package br.upe.model.entities;

import br.upe.service.core.Column;
import br.upe.service.core.Table;

import java.util.Objects;

@Table(name="users")
public class
User {

    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="cpf")
    private String cpf;

    @Column(name="birthday")
    private String birthday;

    @Column(name="password")
    private String password;

    @Column(name="crm")
    private String crm;

    @Column(name="user_role_id")
    private int userRoleId;

    @Column(name="cpf")
    private String cpf;

    public User(){
    }

    public User(int id, String name, String email, String cpf, String birthday, String password, String crm, int userRoleId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthday = birthday;
        this.password = password;
        this.crm = crm;
        this.userRoleId = userRoleId;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthday='" + birthday + '\'' +
                ", password='" + password + '\'' +
                ", crm='" + crm + '\'' +
                ", userRoleId=" + userRoleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
