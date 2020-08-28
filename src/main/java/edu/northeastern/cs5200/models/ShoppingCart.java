package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue
	(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	private String customerName;
	private String productNumber;
	private int pid;
	private String productName;
	private int productQty;
	private int productSum;
	
	//One to one for customer
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="customer_id")
	private Customer thisCustomerShoppingCart;
	
	//One to many for items
	@OneToMany(mappedBy = "itemsInThisShoppingCart", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Items> itemsOfshoppingCart;
	
	//One to many for order
	@OneToMany(mappedBy = "thisOrder", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Order> orderOfshoppingCart;
	
	public ShoppingCart() {
		
	}
	public ShoppingCart(String customerName, String productNumber) {
		this.customerName = customerName;
		this.productNumber = productNumber;
	}
public ShoppingCart(int pid, String productName, int productQty, int productSum) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.productQty = productQty;
		this.productSum = productSum;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	//Customer
	public Customer getThisCustomerShoppingCart() {
		return thisCustomerShoppingCart;
	}
	public void setThisCustomerShoppingCart(Customer thisCustomerShoppingCart) {
		this.thisCustomerShoppingCart = thisCustomerShoppingCart;
	}
	
	//Items
	public void itemsOfshoppingCart(Items items) {
		this.itemsOfshoppingCart.add(items);
		if(items.getItemsInThisShoppingCart() != this) {
			items.setItemsInThisShoppingCart(this);
		}
	}
	public void removeItemsOfshoppingCart(Items items) {
		this.itemsOfshoppingCart.remove(items);
		items.setItemsInThisShoppingCart(null);;
	}
	public List<Items> getItemsOfshoppingCart() {
		return itemsOfshoppingCart;
	}
	public void setItemsOfshoppingCart(List<Items> itemsOfshoppingCart) {
		this.itemsOfshoppingCart = itemsOfshoppingCart;
	}
	//Order
	public void orderOfshoppingCart(Order order) {
		this.orderOfshoppingCart.add(order);
		if(order.getThistOrder() != this) {
			order.setThisOrder(this);
		}
	}
	public void removeOrderOfshoppingCart(Order order) {
		this.orderOfshoppingCart.remove(order);
		order.setThisOrder(null);
	}
	public List<Order> getOrderOfshoppingCart() {
		return orderOfshoppingCart;
	}
	public void setOrderOfshoppingCart(List<Order> orderOfshoppingCart) {
		this.orderOfshoppingCart = orderOfshoppingCart;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public int getProductSum() {
		return productSum;
	}
	public void setProductSum(int productSum) {
		this.productSum = productSum;
	}
	
	
	
	
	

}
