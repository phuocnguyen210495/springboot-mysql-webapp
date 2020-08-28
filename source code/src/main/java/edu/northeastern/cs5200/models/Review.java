package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Entity
public class Review {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String productNumber;
	private String description;
	private String rate;
	
	//Many to one for customer
	@ManyToOne()
	@JoinColumn(name = "customer_id")
	private Customer thisCustomerReview;
	
	//Many to one for product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product thisProductReview;
    
  //Many to one for shopper
    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shopper thisShopperReview;
    
	
	public Review() {
		
	}
	public Review(String productNumber, String description, String rate) {
		this.productNumber = productNumber;
		this.description = description;
		this.rate = rate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	//Customer
	public Customer getThisCustomerReview() {
		return thisCustomerReview;
	}
	public void setThisCustomerReview(Customer thisCustomerReview) {
		this.thisCustomerReview = thisCustomerReview;
		if(!thisCustomerReview.getReviewsFromThisCustomer().contains(this)) {
			thisCustomerReview.getReviewsFromThisCustomer().add(this);
		}
	}
	//Product
	public Product getThisProductReview() {
		return thisProductReview;
	}
	public void setThisProductReview(Product thisProductReview) {
		this.thisProductReview = thisProductReview;
		if(!thisProductReview.getReviewForThisProduct().contains(this)) {
			thisProductReview.getReviewForThisProduct().add(this);
		}
	}
	//Shopper
	public Shopper getThisShopperReview() {
		return thisShopperReview;
	}
	public void setThisShopperReview(Shopper thisShopperReview) {
		this.thisShopperReview = thisShopperReview;
		if(!thisShopperReview.getReviewForThisShopper().contains(this)) {
			thisShopperReview.getReviewForThisShopper().add(this);
		}
	}
	
	

}
