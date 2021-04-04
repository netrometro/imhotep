package br.upe.models;

import org.joda.time.DateTime;

public class Patient extends User{

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int id, String email, String firstName, String lastName, String cpf, String birthDate,
			String password) {
		super(id, email, firstName, lastName, cpf, birthDate, password);
		// TODO Auto-generated constructor stub
	}
	
}
