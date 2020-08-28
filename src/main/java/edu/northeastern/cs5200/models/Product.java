package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
public class Product {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
//	private String productNumber;
	private int price;
	private int  salesVolume;
	
	//One to many for items
	@OneToMany(mappedBy = "thisProductItems", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Items> itemsOfThisProduct;
	
	//One to many for review
	@OneToMany(mappedBy = "thisProductReview", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Review> reviewForThisProduct;
	
	//Many to many for seller
	@ManyToMany(mappedBy = "productManagedByThisSeller")
	private List<Seller> sellerManageThisProduct;
 	
	public Product() {}
	
	public Product(String name, String description, int price, int salesVolume) {
		this.name = name;
		this.description = description;
//		this.productNumber = productNumber;
		this.price = price;
		this.salesVolume = salesVolume;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public String getProductNumber() {
//		return productNumber;
//	}
//	public void setProductNumber(String productNumber) {
//		this.productNumber = productNumber;
//	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
	}
	
	//Items
	public void itemsOfThisProduct (Items items) {
		this.itemsOfThisProduct.add(items);
		if(items.getThisProductItems() != this) {
			items.setThisProductItems(this);
		}
	}
	public void removeItemsForThisProduct(Items items) {
		this.itemsOfThisProduct.remove(items);
		items.setThisProductItems(null);
	}
	public List<Items> getItemsOfThisProduct() {
		return itemsOfThisProduct;
	}
	public void setItemsOfThisProduct(List<Items> itemsOfThisProduct) {
		this.itemsOfThisProduct = itemsOfThisProduct;
	}
	
	//Review
	public void reviewForThisProduct(Review reviews) {
		this.reviewForThisProduct.add(reviews);
		if(reviews.getThisProductReview() != this) {
			reviews.setThisProductReview(this);
		}
	}
	public void removeReviewForThisProduct(Review reviews) {
		this.reviewForThisProduct.remove(reviews);
		reviews.setThisProductReview(null);
	}
	public List<Review> getReviewForThisProduct() {
		return reviewForThisProduct;
	}
	public void setReviewForThisProduct(List<Review> reviewForThisProduct) {
		this.reviewForThisProduct = reviewForThisProduct;
	}
	
	//Seller
	public void sellerManageThisProduct(Seller seller) {
		this.sellerManageThisProduct.add(seller);
		if(seller.getProductManagedByThisSeller().contains(this)) {
			seller.getProductManagedByThisSeller().add(this);
		}
	}
	public void removeSellerManageThisProduct (Seller seller) {
		this.sellerManageThisProduct.remove(seller);
		if(!seller.getProductManagedByThisSeller().contains(this)) {
			seller.getProductManagedByThisSeller().remove(this);
		}
	}
	public List<Seller> getSellerManageThisProduct() {
		return sellerManageThisProduct;
	}
	public void setSellerManageThisProduct(List<Seller> sellerManageThisProduct) {
		this.sellerManageThisProduct = sellerManageThisProduct;
	}
	
	

}
