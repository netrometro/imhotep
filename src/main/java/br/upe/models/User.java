package br.upe.models;

import org.joda.time.DateTime;

public class User {
	
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String cpf;
	private String birthDate;//private DateTime birthDate;
	private String password;
	
	public static final String TABLE_NAME = "_user";
	public static final String ID = "id"; 
	public static final String EMAIL = "email";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String CPF = "cpf";
	public static final String BIRTH_DATE = "birthDate";
	public static final String PASSWORD = "password";
	
	public User() {}

	public User(int id, String email, String firstName, String lastName, String cpf, String birthDate,
			String password) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", cpf="
				+ cpf + ", birthDate=" + birthDate + ", password=" + password + "]";
	}
	
	
	
}
