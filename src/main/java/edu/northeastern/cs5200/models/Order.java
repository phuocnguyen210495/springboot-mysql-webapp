package edu.northeastern.cs5200.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue
	(strategy = GenerationType.AUTO)
	private int id;
	private int cid;
	private int sid;
	private int sum;

    @Column(name = "update_date")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
       
//	private String orderNumber;
    private String date;
	
	//Many to one for customer
	@ManyToOne()
	private Customer thisCustomerOrder;
	
	//Many to one for shoppingCart
	@ManyToOne()
	private ShoppingCart thisOrder;
	
	//Many to one for shopper
	@ManyToOne()
	private Shopper thisShopperOrder;
	
//	One to many for items（aggregation)
	@OneToMany(mappedBy = "thisOrderItems", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	private List<Items> itemsOfThisOrder;
	
	//One to one for billing
	@OneToOne(mappedBy = "thisOrderBilling", cascade = CascadeType.ALL)
	private Billing billingOfOrder;
	
	public Order() {
		
	}
	
	public Order(String date, int sum, int cid, int sid) {
		this.date = date;
//		this.orderNumber = orderNumber;
		this.sum = sum;
		this.cid = cid;
		this.sid = sid;
	}
	public Order(int id, int cid, int sid, int sum, Date updateDate) {
		this.id = id;
		this.cid = cid;
		this.sid = sid;
		this.sum = sum;
		this.updateDate = updateDate;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
//	public String getOrderNumber() {
//		return orderNumber;
//	}
//	public void setOrderNumber(String orderNumber) {
//		this.orderNumber = orderNumber;
//	}
	//Customer
	public Customer getThisCustomerOrder() {
		return thisCustomerOrder;
	}

	public void setThisCustomerOrder(Customer thisCustomerOrder) {
		this.thisCustomerOrder = thisCustomerOrder;
		if(!thisCustomerOrder.getOrderForThisCustomer().contains(this)) {
			thisCustomerOrder.getOrderForThisCustomer().add(this);
		}
	}
	//Items
	public void itemsOfThisOrder(Items items) {
		this.itemsOfThisOrder.add(items);
		if(items.getThisOrderItems() != this) {
			items.setThisOrderItems(this);
		}
	}
	public void removeItemsOfThisOrder(Items items) {
		this.itemsOfThisOrder.remove(items);
		items.setThisOrderItems(null);
	}// ?
	public List<Items> getItemsOfThisOrder() {
		return itemsOfThisOrder;
	}

	public void setItemsOfThisOrder(List<Items> itemsOfThisOrder) {
		this.itemsOfThisOrder = itemsOfThisOrder;
	}
	//Billing	
	public Billing getBillingOfOrder() {
		return billingOfOrder;
	}

	public void setBillingOfOrder(Billing billingOfOrder) {
		this.billingOfOrder = billingOfOrder;
	}
	//ShoppingCart
	public ShoppingCart getThistOrder() {
		return thisOrder;
	}
	
	public void setThisOrder(ShoppingCart thisOrder) {
		this.thisOrder = thisOrder;
		if(!thisOrder.getOrderOfshoppingCart().contains(this)) {
			thisOrder.getOrderOfshoppingCart().add(this);
		}
	}
	//Shopper
	public Shopper getThisShopperOrder() {
		return thisShopperOrder;
	}

	public void setThisShopperOrder(Shopper thisShopperOrder) {
		this.thisShopperOrder = thisShopperOrder;
		if(!thisShopperOrder.getOrderForThisShopper().contains(this)) {
			thisShopperOrder.getOrderForThisShopper().add(this);
		}
	
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public ShoppingCart getThisOrder() {
		return thisOrder;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
