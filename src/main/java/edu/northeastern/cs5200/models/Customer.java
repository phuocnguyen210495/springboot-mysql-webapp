package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Customer extends User{
	private Boolean active;
	private Boolean blocked;
	
	//One to many for reviews
	@OneToMany(mappedBy = "thisCustomerReview", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Review> reviewsFromThisCustomer;
	
	//One to many for address
	@OneToMany(mappedBy = "thisCustomerAddress", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Address> addressForCustomer;
	
//	//One to many for order
	@OneToMany(mappedBy = "thisCustomerOrder", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Order> orderForThisCustomer;
	
	//One to one for shopping cart
	@OneToOne
	@JoinColumn(name="customer_id", referencedColumnName="id")
	private ShoppingCart shoppingCart;
	
	
	public Customer () {
		super();
	}
	
	public Customer (String firstName, String lastName, String password, String email, String phone, String userDtype, Boolean active, Boolean blocked) {
		super(firstName, lastName, password, email, phone, userDtype);
		this.active = active;
		this.blocked = blocked;
	}
	public Customer (String firstName, String lastName, String password, String email, String phone, String userDtype, List<Order> orderForThisCustomer) {
		super(firstName, lastName, password, email, phone, userDtype);
		this.orderForThisCustomer = orderForThisCustomer;
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
	//ShoppingCart
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	//Review
	public void reviewsFromThisCustomer(Review reviews) {
		this.reviewsFromThisCustomer.add(reviews);
		if(reviews.getThisCustomerReview() != this)
		   reviews.setThisCustomerReview(this);
	}
	public void removeReviewsFromThisCustomer(Review reviews) {
		this.reviewsFromThisCustomer.remove(reviews);
		reviews.setThisCustomerReview(null);
	}
	public List<Review> getReviewsFromThisCustomer() {
		return reviewsFromThisCustomer;
	}

	public void setReviewsFromThisCustomer(List<Review> reviewsFromThisCustomer) {
		this.reviewsFromThisCustomer = reviewsFromThisCustomer;
	}
	//Address
	public void addressForCustomer(Address address) {
		this.addressForCustomer.add(address);
		if(address.getThisCustomerAddress() != this) {
			address.setThisCustomerAddress(this);
		}
	}
	public void removeAddressForCustomer(Address address) {
		this.addressForCustomer.remove(address);
		address.setThisCustomerAddress(null);
	}
	public List<Address> getAddressForCustomer() {
		return addressForCustomer;
	}

	public void setAddressForCustomer(List<Address> addressForCustomer) {
		this.addressForCustomer = addressForCustomer;
	}
	//Order
	public void orderForThisCustomer(Order order) {
		this.orderForThisCustomer.add(order);
		if(order.getThisCustomerOrder() != this) {
			order.setThisCustomerOrder(this);
		}
	}
	public void removeOrderForThisCustomer(Order order) {
		this.orderForThisCustomer.remove(order);
		order.setThisCustomerOrder(null);
	}
	public List<Order> getOrderForThisCustomer() {
		return orderForThisCustomer;
	}

	public void setOrderForThisCustomer(List<Order> orderForThisCustomer) {
		this.orderForThisCustomer = orderForThisCustomer;
	}
	
	

}
