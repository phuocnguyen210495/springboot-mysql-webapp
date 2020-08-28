package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Customer;
//import edu.northeastern.cs5200.models.Order;
import edu.northeastern.cs5200.models.Review;
import edu.northeastern.cs5200.models.ShoppingCart;
import edu.northeastern.cs5200.repositories.AddressRepository;
import edu.northeastern.cs5200.repositories.BillingRepository;
import edu.northeastern.cs5200.repositories.CustomerRepository;
//import edu.northeastern.cs5200.repositories.OrderRepository;
import edu.northeastern.cs5200.repositories.ReviewRepository;
import edu.northeastern.cs5200.repositories.ShoppingCartRepository;

@Controller("CustomerDao")
public class CustomerDao {
	@Autowired
	CustomerRepository customerRepository;
//	@Autowired
//	OrderRepository orderRepository;
	@Autowired
	BillingRepository billingRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	//create
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	//delete
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}
	
	public void deleteCustomerById(int id) {
		customerRepository.deleteById(id);
	}
	
	//find
	public Customer findCustomerById(int id) {
		Customer c = (Customer) customerRepository.findById(id).get();
		return c;
	}
	
	public List<Customer> findAllCustomers() {
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		return customers;
	}
	
	public Customer findCustomerByCredentials(String email, String password) {
		Customer customer = customerRepository.findCustomerByCredentials(email, password);
		return customer;
	}
	
	public Customer findCustomerByEmail(String email) {
		Customer customer = customerRepository.findCustomerByEmail(email);
		return customer;
	}
	
	//other operations
	public Customer updateCustomer(int id, Customer customer) {
		Customer c = (Customer) customerRepository.findById(id).get();
		c.setEmail(customer.getEmail());
		c.setFirstName(customer.getFirstName());
		c.setLastName(customer.getLastName());
		c.setPassword(customer.getPassword());
		customerRepository.save(c);
		return c;
	}
//	//order
//	public Customer addOrderToCustomer(Order order, Customer customer) {
//		customer.orderForThisCustomer(order);
//		orderRepository.save(order);
//		return customerRepository.save(customer);
//	}
//	
//	public void deleteOrderFromCustomer(Order order, Customer customer){
//    	customer.removeOrderForThisCustomer(order);
//    	customerRepository.save(customer);
//    	orderRepository.save(order);
//    }
	
	public Customer addAddressToCustomer(Address address, Customer customer) {
		customer.addressForCustomer(address);
		addressRepository.save(address);
		return customerRepository.save(customer);
	}
	
	public void deleteAddressFromCustomer(Address address, Customer customer){
    	customer.removeAddressForCustomer(address);
    	customerRepository.save(customer);
    	addressRepository.save(address);
    }
	
	public Customer addReview(Review reviews, Customer customer) {
		customer.reviewsFromThisCustomer(reviews);
		reviewRepository.save(reviews);
		return customerRepository.save(customer);
	}
	
	public void deleteReview(Review reviews, Customer customer){
		customer.removeReviewsFromThisCustomer(reviews);
		customerRepository.save(customer);
    	reviewRepository.save(reviews);
    }

	//Click on the shopping cart
	public Customer enableShoppingCart(ShoppingCart shoppingCart, Customer customer){
    	customer.setShoppingCart(shoppingCart);
    	shoppingCartRepository.save(shoppingCart);
    	return customerRepository.save(customer);
    }
	
	public Customer activeCustomer(Customer customer){
    	customer.setActive(true);
    	customerRepository.save(customer);
    	return customerRepository.save(customer);
    }
	
	public Customer blockCustomer(Customer customer){
    	customer.setBlocked(true);
    	customerRepository.save(customer);
    	return customerRepository.save(customer);
    }
	
}
