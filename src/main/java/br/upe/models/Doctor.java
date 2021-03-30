package br.upe.models;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Doctor extends User{
	
	private String crm;
	private ArrayList<DateTime> horarios = new ArrayList<DateTime>();

	public Doctor() {
		super();

	}

	public Doctor(int id, String email, String firstName, String lastName, String cpf, DateTime birthDate,
			String password, ArrayList<DateTime> horarios) {
		super(id, email, firstName, lastName, cpf, birthDate, password);
		this.horarios = horarios;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public ArrayList<DateTime> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<DateTime> horarios) {
		this.horarios = horarios;
	}

	
	
	
}
