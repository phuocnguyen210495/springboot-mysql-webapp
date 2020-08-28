package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Admin extends User{
	
	public Admin() {
		super();
	}
	
	public Admin(String firstName, String lastName, String password, String email, String phone, String userDtype) {
		super(firstName, lastName, password, email, phone, userDtype);
	}

}
