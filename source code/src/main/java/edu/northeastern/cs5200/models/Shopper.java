package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Shopper extends User{
	private int tips;
	private Boolean active;
	private Boolean blocked;
	
	//One to Many for order
	@OneToMany(mappedBy = "thisShopperOrder", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Order> orderForThisShopper;
	
	//One to many for review
		@OneToMany(mappedBy = "thisShopperReview", orphanRemoval = true, fetch = FetchType.EAGER)
		@Fetch(value = FetchMode.SELECT)
		@OnDelete(action = OnDeleteAction.CASCADE)
		private List<Review> reviewForThisShopper;
		
	
	public Shopper () {
		super();
	}
	
	public Shopper (String firstName, String lastName, String password, String email, String phone, String userDtype, Boolean active, Boolean blocked, int tips) {
		super(firstName, lastName, password, email, phone, userDtype);
		this.active = active;
		this.blocked = blocked;
		this.tips = tips;
	}
	
	
	public int getTips() {
		return tips;
	}
	public void setTips(int tips) {
		this.tips = tips;
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
	//Order
	public void orderForThisShopper (Order order) {
		this.orderForThisShopper.add(order);
		if(order.getThisShopperOrder() != this) {
			order.setThisShopperOrder(this);
		}
	}
	public void removeOrderForThisShopper(Order order) {
		this.getOrderForThisShopper().remove(order);
		order.setThisShopperOrder(null);
	}
	public List<Order> getOrderForThisShopper() {
		return orderForThisShopper;
	}

	public void setOrderForThisShopper(List<Order> orderForThisShopper) {
		this.orderForThisShopper = orderForThisShopper;
	}
	//Review
	public void reviewForThisShopper(Review reviews) {
		this.reviewForThisShopper.add(reviews);
		if(reviews.getThisShopperReview() != this) {
			reviews.setThisShopperReview(this);
		}
	}
	public void removeReviewFromThisShopper(Review reviews) {
		this.reviewForThisShopper.remove(reviews);	
			reviews.setThisShopperReview(null);
		
	}
	public List<Review> getReviewForThisShopper() {
		return reviewForThisShopper;
	}

	public void setReviewForThisShopper(List<Review> reviewForThisShopper) {
		this.reviewForThisShopper = reviewForThisShopper;
	}
		
}
