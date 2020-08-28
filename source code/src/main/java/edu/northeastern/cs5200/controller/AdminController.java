package edu.northeastern.cs5200.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.northeastern.cs5200.daos.AdminDao;
import edu.northeastern.cs5200.daos.CustomerDao;
import edu.northeastern.cs5200.daos.OrderDao;
import edu.northeastern.cs5200.daos.ProductDao;
import edu.northeastern.cs5200.daos.SellerDao;
import edu.northeastern.cs5200.daos.ShopperDao;
import edu.northeastern.cs5200.daos.ShoppingCartDao;
import edu.northeastern.cs5200.daos.UserDao;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.Shopper;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.ItemsRepository;
import edu.northeastern.cs5200.repositories.ReviewRepository;
import edu.northeastern.cs5200.repositories.ShoppingCartRepository;

@Controller
public class AdminController {
	@Autowired
	UserDao userDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ShoppingCartDao shoppingCartDao;
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	@Autowired
	ProductDao productDao;
	@Autowired
	ItemsRepository itemsRepository;
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	ShopperDao shopperDao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	AdminDao adminDao;
	@Autowired
	SellerDao sellerDao;
	
	//An admin creates a user
	@RequestMapping(value = "/admin/createUser", method = RequestMethod.POST)
	public String adminCreateUser(Model model, HttpServletRequest request, HttpSession session) {
		String userRole = request.getParameter("userRole");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		if (userRole != null && userRole.equals("Customer")) {
			Customer customer = new Customer(email, firstName, lastName, password, phone, userRole, true, false);
			customerDao.createCustomer(customer);
			return "front/create_success";
		} else if (userRole != null && userRole.equals("Shopper")) {
			Shopper shopper = new Shopper(firstName, lastName, password, email, phone, userRole, true, false, 0);
			shopperDao.createShopper(shopper);
			return "front/create_success";
		} else {
			return "front/failed";
		}
	}

	
	//An admin lists all users
	@RequestMapping(value = "/admin/listUser", method = RequestMethod.POST)
	public String adminListUser(Model model, HttpServletRequest request, HttpSession session) {
		List<User> users = adminDao.findAllUsers();
		request.setAttribute("users", users);
		return "front/all_users";
	}
	
	//An admin removes a user
	@RequestMapping(value = "/admin/deleteUser", method = RequestMethod.POST)
	public String adminDeleteUser(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("delete a user");
		String email = request.getParameter("email");
		User user = adminDao.findUserByEmail(email);
		int uid = user.getId();
		adminDao.deleteUserById(uid);
		return "front/delete_success";
	}
	@RequestMapping(value = "/admin/deleteAll", method = RequestMethod.POST)
	public String adminDeleteAll(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("delete all user");
		userDao.deleteAllUsers();
		return "front/delete_success";
	}
	
	//An admin edits/updates a particular user
	@RequestMapping(value = "/admin/updateUser", method = RequestMethod.POST)
	public String adminUpdateUser(Model model, HttpServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		String newUserRole = request.getParameter("userDtype");
		User user = userDao.findUserByEmail(email);
		if (user != null) {
			user.setUserDtype(newUserRole);
			String userRole = user.getUserDtype();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String phone = user.getPhone();
			
			request.setAttribute("userRole", userRole);
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("phone", phone);
		}
		if (newUserRole != null && newUserRole.equals("Customer")) {
			return "front/customer_info";
		} else if (newUserRole != null && newUserRole.equals("Shopper")) {
			return "front/shopper_info";
		} else {
			return "front/admin";
		}
	}
	
	@RequestMapping(value = "/admin/show/updateUser", method = RequestMethod.POST)
	public String showUser(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("show user");
		String email = request.getParameter("email");
		String newUserRole = request.getParameter("userDtype");
		User user = userDao.findUserByEmail(email);
		user.setUserDtype(newUserRole);
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String phone = user.getPhone();
		
		request.setAttribute("userRole", newUserRole);
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("phone", phone);
		if (user.getUserDtype().equals("Customer")) {
			return "front/update_success";
		} else if (user.getUserDtype().equals("Shopper")) {
			return "front/update_success";
		} else if (user.getUserDtype().equals("Admin")) {
			return "front/admin";
		} else {
			return "front/failed";
		}
	}
	
}
