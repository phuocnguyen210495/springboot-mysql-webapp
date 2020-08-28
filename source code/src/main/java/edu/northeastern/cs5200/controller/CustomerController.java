//package edu.northeastern.cs5200.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import edu.northeastern.cs5200.daos.CustomerDao;
//import edu.northeastern.cs5200.daos.OrderDao;
//import edu.northeastern.cs5200.daos.UserDao;
////import edu.northeastern.cs5200.daos.OrderDao;
//import edu.northeastern.cs5200.models.Address;
//import edu.northeastern.cs5200.models.Customer;
////import edu.northeastern.cs5200.models.Order;
//import edu.northeastern.cs5200.models.Review;
//import edu.northeastern.cs5200.models.ShoppingCart;
//import edu.northeastern.cs5200.models.User;
//import edu.northeastern.cs5200.repositories.AddressRepository;
//import edu.northeastern.cs5200.repositories.ReviewRepository;
//import edu.northeastern.cs5200.repositories.ShoppingCartRepository;
//
//@Controller
//public class CustomerController {
//	@Autowired
//	CustomerDao customerDao;
//	@Autowired
//	UserDao userDao;
//	@Autowired
//	OrderDao orderDao;
//	@Autowired
//	AddressRepository addressRepository;
//	@Autowired
//	ReviewRepository reviewRepository;
//	@Autowired
//	ShoppingCartRepository shoppingCartRepository;
//
//	@RequestMapping(value="/show/customer",method = RequestMethod.GET)
//	public String showCustomer(HttpServletRequest request, HttpSession session) {
//		System.out.println("show customer");
//		String email = request.getParameter("email");
//		User user = userDao.findUserByEmail(email);
//		String userRole = request.getParameter(user.getUserDtype());
//		String firstName = request.getParameter(user.getFirstName());
//		String lastName = request.getParameter(user.getLastName());
//		String phone = request.getParameter(user.getPhone());
//		
//		request.setAttribute("userRole", userRole);
//		request.setAttribute("firstName", firstName);
//		request.setAttribute("lastName", lastName);
//		request.setAttribute("phone", phone);
//	    return "front/customer_info";
//	}
//	
//	//apply
////	@RequestMapping(value="/apply", method = RequestMethod.POST)
////	public String apply(HttpServletRequest request, HttpSession session) {
////		System.out.println("Start Application");
////		String customerEmail = request.getParameter("email");
////		String customerPassWord = request.getParameter("password");
////		String productName = request.getParameter("productName");
////		if(customerEmail != null & productName != null ) {
////			
////		}
////	}
//	
//	//create
//	@PostMapping("/api/customer/{cid}")
//	public Customer createCustomer(@RequestBody Customer customer) {
//		return customerDao.createCustomer(customer);
//	}
//	
//	//delete
//	@DeleteMapping("/api/customer")
//	public void deleteAllCustomer() {
//		customerDao.deleteAllCustomers();
//	}
//	@DeleteMapping("/api/customer/{cid}")
//	public void deleteCustomerById(@PathVariable("cid") int cid) {
//		customerDao.deleteCustomerById(cid);
//	}
//	
//	//find
//	@GetMapping("/api/customer/{cid}") 
//	public Customer findCustomerById(@PathVariable("cid") int cid) {
//		Customer customer = customerDao.findCustomerById(cid);
//		return customer;
//	}
//	@GetMapping("/api/customer") 
//	public Iterable<Customer> findAllCustomers() {
//		Iterable<Customer> customer = customerDao.findAllCustomers();
//		return customer;
//	}
//	//update
//	@PutMapping("/api/customer/{cid}")
//	public Customer updateCustomer(@PathVariable("cid") int cid, @RequestBody Customer c) {
//		Customer customer = customerDao.updateCustomer(cid, c);
//		return customer;
//	}
//	//order
////	@PostMapping("/api/customer/{cid}/order/{oid}") 
////	public Customer addOrderToCustomer(@PathVariable("cid") int cid, @PathVariable("oid") int oid) {
////		Customer customer = customerDao.findCustomerById(cid);
////		Order order = orderDao.findOrderById(oid);
////		return customerDao.addOrderToCustomer(order, customer);
////	}	
////	@PostMapping("/api/customer/{cid}/order/{oid}") 
////	public void deleteOrderFromCustomer(@PathVariable("cid") int cid, @PathVariable("oid") int oid) {
////		Customer customer = customerDao.findCustomerById(cid);
////		Order order = orderDao.findOrderById(oid);
////		customerDao.deleteOrderFromCustomer(order, customer);
////	}
//	//address
//	@PostMapping("/api/customer/{cid}/address/{aid}")
//	public Customer addAddressToCustomer(@PathVariable("cid") int cid, @PathVariable("aid") int aid) {
//		Customer customer = customerDao.findCustomerById(cid);
//		Address address = addressRepository.findById(aid).get();
//		return customerDao.addAddressToCustomer(address, customer);
//	}
//	@PostMapping("/api/customer/{cid}/address/{aid}")
//	public void deleteAddressFromCustomer(@PathVariable("cid") int cid, @PathVariable("aid") int aid) {
//		Customer customer = customerDao.findCustomerById(cid);
//		Address address = addressRepository.findById(aid).get();
//		customerDao.deleteAddressFromCustomer(address, customer);
//	}
//	//review
//	@PostMapping("/api/customer/{cid}/review/{rid}")
//	public Customer addReviewToCustomer(@PathVariable("cid") int cid, @PathVariable("rid") int rid) {
//		Customer customer = customerDao.findCustomerById(cid);
//		Review reviews = reviewRepository.findById(rid).get();
//		return customerDao.addReview(reviews, customer);
//	}
//	@PostMapping("/api/customer/{cid}/review/{rid}")
//	public void deleteReviewFromCustomer(@PathVariable("cid") int cid, @PathVariable("rid") int rid) {
//		Customer customer = customerDao.findCustomerById(cid);
//		Review reviews = reviewRepository.findById(rid).get();
//		customerDao.deleteReview(reviews, customer);
//	}
//	//Click on the shopping cart
//	@PostMapping("/api/customer/{cid}/shoppingCart/{sid}")
//	public Customer enableShoppingCart(@PathVariable("cid") int cid, @PathVariable("sid") int sid) {
//		Customer customer = customerDao.findCustomerById(cid);
//		ShoppingCart shoppingCart = shoppingCartRepository.findById(sid).get();
//		return customerDao.enableShoppingCart(shoppingCart, customer);
//	}
//	@PutMapping("/api/seller")//not sure if it is right
//	public Customer activeCustomer(@RequestBody Customer c) {
//		Customer customer = customerDao.activeCustomer(c);
//		return customer;
//	}
//	@PutMapping("/api/seller")//not sure if it is right
//	public Customer blockCustomer(@RequestBody Customer c) {
//		Customer customer = customerDao.blockCustomer(c);
//		return customer;
//	}
//	
//	
//}
