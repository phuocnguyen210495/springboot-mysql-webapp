package edu.northeastern.cs5200.models;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Entity
public class Address {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zip;
	
	//Many to one for customer
	@ManyToOne()
	private Customer thisCustomerAddress;
	
	//Many to one for seller
	@ManyToOne()
	private Seller thisSellerAddress;
	
	public Address() {
		
	}
	
	public Address(String street, String city, String state, String country, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	//Customer
	public Customer getThisCustomerAddress() {
		return thisCustomerAddress;
	}

	public void setThisCustomerAddress(Customer thisCustomerAddress) {
		this.thisCustomerAddress = thisCustomerAddress;
		if(!thisCustomerAddress.getAddressForCustomer().contains(this)) {
			thisCustomerAddress.getAddressForCustomer().add(this);
		}
	}
	//Seller
	public Seller getThisSellerAddress() {
		return thisSellerAddress;
	}

	public void setThisSellerAddress(Seller thisSellerAddress) {
		this.thisSellerAddress = thisSellerAddress;
		if(!thisSellerAddress.getAddressForSeller().contains(this)) {
			thisSellerAddress.getAddressForSeller().add(this);
		}
	}

	
	

}
