package edu.northeastern.cs5200.daos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Order;
import edu.northeastern.cs5200.models.Shopper;
import edu.northeastern.cs5200.repositories.OrderRepository;

@Controller("OrderDao")
public class OrderDao {
	@Autowired
	OrderRepository orderRepository;
	
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public void deleteAllOrders() {
		orderRepository.deleteAll();
	}
	
	public void deleteOrderById(int id) {
		orderRepository.deleteById(id);
	}
	
	public List<Order> findAllBillings() {
		List<Order> orders = (List<Order>) orderRepository.findAll();
		return orders;
	}
	
	public Order findOrderById(int id) {
		Order o = (Order) orderRepository.findById(id).get();
		return o;
	}
	
	public Order findOrderByDate(Date date) {
		Order o = (Order) orderRepository.findOrderByDate(date);
		return o;
	}
	
	public Order findOrderByCustomer(Customer thisCustomerOrder) {
		Order o = (Order) orderRepository.findOrderByCustomer(thisCustomerOrder);
		return o;
	}
	public Order findOrderByCid(int cid) {
		Order o = (Order) orderRepository.findOrderByCid(cid);
		return o;
	}
	
	public Order findOrderByShopper(Shopper thisShopperOrder) {
		Order o = (Order) orderRepository.findOrderByShopper(thisShopperOrder);
		return o;
	}
	
//	public Order findOrderByOrderNumber(String orderNumber) {
//		Order order = orderRepository.findOrderByOrderNumber(orderNumber);
//		return order;
//	}
}
