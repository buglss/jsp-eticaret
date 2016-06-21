package com.eticaret.model;

public class User {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String city;
	private int role_id;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String first_name, String last_name, String kullaniciAdi, String email, String password, String city, int role_id) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.role_id = role_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRoleId() {
		return role_id;
	}

	public void setRoleId(int role_id) {
		this.role_id = role_id;
	}

}
