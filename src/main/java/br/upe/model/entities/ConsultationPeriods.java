package br.upe.model.entities;

import br.upe.service.core.Column;
import br.upe.service.core.Table;

@Table(name="consultation_periods")
public class ConsultationPeriods {
    @Column(name="id")
    private int id;
    @Column(name="sunday")
    private String sunday;
    @Column(name="monday")
    private String monday;
    @Column(name="tuesdat")
    private String tuesday;
    @Column(name="wednesday")
    private String wednesday;
    @Column(name="thursday")
    private String thursday;
    @Column(name="friday")
    private String friday;
    @Column(name="saturday")
    private String saturday;
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSunday() {
        return this.sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getMonday() {
        return this.monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return this.tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return this.wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return this.thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return this.friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return this.saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }
}