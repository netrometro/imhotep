package br.upe.models;

import org.joda.time.DateTime;

public class Doctor extends User{
	
	private String crm;

	public Doctor() {
		super();

	}

	public Doctor(int id, String email, String firstName, String lastName, String cpf, DateTime birthDate,
			String password) {
		super(id, email, firstName, lastName, cpf, birthDate, password);

	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

}
