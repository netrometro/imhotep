package br.upe.models;

import org.joda.time.DateTime;

public class Employee extends User{

	private int id_doctor;
	
	public Employee() {
		super();

	}

	public Employee(int id, String email, String firstName, String lastName, String cpf, DateTime birthDate,
			String password) {
		super(id, email, firstName, lastName, cpf, birthDate, password);
		// TODO Auto-generated constructor stub
	}

	public int getId_doctor() {
		return id_doctor;
	}

	public void setId_doctor(int id_doctor) {
		this.id_doctor = id_doctor;
	}
}
