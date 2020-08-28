package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Seller extends User{
	private Boolean active;
	private Boolean blocked;
	
	//One to many for address
		@OneToMany(mappedBy = "thisSellerAddress", orphanRemoval = true, fetch = FetchType.EAGER)
		@Fetch(value = FetchMode.SELECT)
		@OnDelete(action = OnDeleteAction.CASCADE)
		private List<Address> addressForSeller;
	
	//Many to many for product
		@ManyToMany
		@JoinTable(
		  name = "SellerManageProduct", 
		  joinColumns = @JoinColumn(name = "seller_id",referencedColumnName="ID"), 
		  inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName="ID"))
		  private List<Product> productManagedByThisSeller;
	
	public Seller () {
		super();
	}
	
	public Seller (String firstName, String lastName, String password, String email, String phone, String userDtype, Boolean active, Boolean blocked) {
		super(firstName, lastName, password, email, phone, userDtype);
		this.active = active;
		this.blocked = blocked;
	}
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getBlocked() {
		return blocked;
	}
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
	//Address
	public void addressForSeller(Address address) {
		this.addressForSeller.add(address);
		if(address.getThisSellerAddress() != this) {
			address.setThisSellerAddress(this);
		}
	}
	public void removeAddressForSeller(Address address) {
		this.addressForSeller.remove(address);
		address.setThisSellerAddress(null);
	}
	public List<Address> getAddressForSeller() {
		return addressForSeller;
	}

	public void setAddressForSeller(List<Address> addressForSeller) {
		this.addressForSeller = addressForSeller;
	}
	//Product
	public void productManagedByThisSeller(Product products) {
		this.productManagedByThisSeller.add(products);
		if(!products.getSellerManageThisProduct().contains(this)) {
			products.getSellerManageThisProduct().add(this);
		}
	}
	public void removeProductManagedByThisSeller(Product products) {
		this.productManagedByThisSeller.remove(products);
		if(!products.getSellerManageThisProduct().contains(this)) {
			products.getSellerManageThisProduct().remove(this);
		}
	}
	public List<Product> getProductManagedByThisSeller() {
		return productManagedByThisSeller;
	}

	public void setProductManagedByThisSeller(List<Product> productManagedByThisSeller) {
		this.productManagedByThisSeller = productManagedByThisSeller;
	}
	

}
