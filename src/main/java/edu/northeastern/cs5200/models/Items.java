package edu.northeastern.cs5200.models;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Entity
public class Items {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private int quantity;
	private int price;
	
	//Many to One for shoppingCart
	@ManyToOne
	private ShoppingCart itemsInThisShoppingCart;
	
	//Many to one for order
	@ManyToOne
	private Order thisOrderItems;
	
	//Many to one for product
	@ManyToOne
	private Product thisProductItems;
	
	
	public Items() {
		
	}
	
	public Items(int quantity, int price) {
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	//ShoppingCart
	public ShoppingCart getItemsInThisShoppingCart() {
		return itemsInThisShoppingCart;
	}

	public void setItemsInThisShoppingCart(ShoppingCart itemsInThisShoppingCart) {
		this.itemsInThisShoppingCart = itemsInThisShoppingCart;
		if(!itemsInThisShoppingCart.getItemsOfshoppingCart().contains(this)) {
			itemsInThisShoppingCart.getItemsOfshoppingCart().add(this);
		}
	}	
	//Order
	public Order getThisOrderItems() {
		return thisOrderItems;
	}

	public void setThisOrderItems(Order thisOrderItems) {
		this.thisOrderItems = thisOrderItems;
		if(!thisOrderItems.getItemsOfThisOrder().contains(this)) {
			thisOrderItems.getItemsOfThisOrder().add(this);
		}
	}
	
	//Product
	public Product getThisProductItems() {
		return thisProductItems;
	}

	public void setThisProductItems(Product thisProductItems) {
		this.thisProductItems = thisProductItems;
		if(!thisProductItems.getItemsOfThisProduct().contains(this)) {
			thisProductItems.getItemsOfThisProduct().add(this);
		}
	}
	
	

}
