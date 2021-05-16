package br.upe.model.entities;

import java.sql.Date;

import br.upe.service.core.Column;
import br.upe.service.core.Table;

@Table(name = "consultation_periods")
public class ConsultationEntity {
    @Column(name = "id")
    private int id;
    @Column(name = "period")
    private String period;
    @Column(name = "date")
    private Date date;
    @Column(name = "id_patient")
    private int idPatient;
    @Column(name = "users_crm", foreignKey = true)
    private String userCrm;

    public ConsultationEntity() {
        period = "";
    }

    public ConsultationEntity(int id, String period, Date date, String userCrm, int idPatient) {
        this.id = id;
        this.period = period;
        this.date = date;
        this.userCrm = userCrm;
        this.idPatient = idPatient;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriod() {
        return this.period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getUserCrm() {
        return userCrm;
    }

    public void setUserCrm(String userCrm) {
        this.userCrm = userCrm;
    }

    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}