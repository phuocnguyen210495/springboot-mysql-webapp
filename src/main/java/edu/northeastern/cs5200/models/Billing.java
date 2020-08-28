package edu.northeastern.cs5200.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Billing {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private Date issueDate;
	private Date dueDate;
	private String total;
	
//	//One to one for order
	@OneToOne
	@MapsId
	private Order thisOrderBilling;
//	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
//	Order
	public Order getThisOrderBilling() {
		return thisOrderBilling;
	}
	public void setThisOrderBilling(Order thisOrderBilling) {
		this.thisOrderBilling = thisOrderBilling;
	}
	
	

}
