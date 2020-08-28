package edu.northeastern.cs5200.daos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.northeastern.cs5200.models.Admin;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Order;
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.Shopper;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.AdminRepository;
import edu.northeastern.cs5200.repositories.OrderRepository;
import edu.northeastern.cs5200.repositories.ProductRepository;
import edu.northeastern.cs5200.repositories.UserRepository;

@Controller("AdminDao")
public class AdminDao {
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductRepository productRepository;
	
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	//1.
	//a.Create, Update, Delete users
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public User findUserById(int id) {
		User u = (User) userRepository.findById(id).get();
		return u;
	}
	public User findUserByEmail(String email) {
		User user = userRepository.findUserByEmail(email);
		return user;
	}
	public void deleteAllUsers(){
		userRepository.deleteAll();
	}
	
	public void deleteUserById(int id){
		userRepository.deleteById(id);
	}
	
	//b.Update a user's role
	public User updateUserRole(int id, String userRole) {
		User u = (User) userRepository.findById(id).get();
		u.setUserDtype(userRole);
		userRepository.save(u);
		return u;
	}
	//c.Update at least one other user field
	public User updateUserPhone(int id, String phone) {
		User u = (User) userRepository.findById(id).get();
		u.setPhone(phone);
		userRepository.save(u);
		return u;
	}
	
	//2.
	//a. Create, Update, Delete domain objects
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
	
	public Order findOrderByShopper(Shopper thisShopperOrder) {
		Order o = (Order) orderRepository.findOrderByShopper(thisShopperOrder);
		return o;
	}
	
//	public Order findOrderByOrderNumber(String orderNumber) {
//		Order order = orderRepository.findOrderByOrderNumber(orderNumber);
//		return order;
//	}
	
	//b.Update at least one field of domain objects
	public Product updateProduct(int id, Product product) {
		Product p = (Product) productRepository.findById(id).get();
		p.setName(product.getName());
		p.setDescription(product.getDescription());
//		p.setProductNumber(product.getProductNumber());
		p.setPrice(product.getPrice());
		p.setSalesVolume(product.getSalesVolume());
		productRepository.save(p);
		return p;
	}

}
