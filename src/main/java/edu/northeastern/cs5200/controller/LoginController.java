package edu.northeastern.cs5200.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.northeastern.cs5200.daos.AdminDao;
import edu.northeastern.cs5200.daos.CustomerDao;
import edu.northeastern.cs5200.daos.OrderDao;
import edu.northeastern.cs5200.daos.ProductDao;
import edu.northeastern.cs5200.daos.SellerDao;
import edu.northeastern.cs5200.daos.ShopperDao;
import edu.northeastern.cs5200.daos.ShoppingCartDao;
import edu.northeastern.cs5200.daos.UserDao;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Items;
import edu.northeastern.cs5200.models.Order;
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.Review;
import edu.northeastern.cs5200.models.Shopper;
import edu.northeastern.cs5200.models.ShoppingCart;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.ItemsRepository;
import edu.northeastern.cs5200.repositories.ReviewRepository;
import edu.northeastern.cs5200.repositories.ShoppingCartRepository;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class LoginController {
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

	// login, if success -> customer_infor
	// if failed -> register
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(Model model, HttpServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("login");
		User user = userDao.findUserByEmail(email);
		session.setAttribute("currentUser", user);
		
		if (user != null) {
			if (!user.getPassword().equals(password)) { // password error
				return "front/register";
			} else {
				if (user.getUserDtype().equals("Customer")) {
					return "front/customer_info";
				} else if (user.getUserDtype().equals("Shopper")) {
					return "front/shopper_info";
				} else if (user.getUserDtype().equals("Seller")) {
					return "front/seller_info";
				} else if (user.getUserDtype().equals("Admin")) {
					return "front/admin";
				}
				return "front/register";
			}
		}
		return "front/register";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String requestLogout(HttpSession session) {
		session.invalidate();
		return "front/home";
	}

	@RequestMapping(value = "/show/user", method = RequestMethod.GET)
	public String showUser(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("show user");
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser == null) {
			return "front/failed";
		} else {
			String userRole = currentUser.getUserDtype();
			String firstName = currentUser.getFirstName();
			String lastName = currentUser.getLastName();
			String phone = currentUser.getPhone();
			
			request.setAttribute("userRole", userRole);
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("phone", phone);
			
			if (currentUser.getUserDtype().equals("Customer")) {
				return "front/customer_info";
			} else if (currentUser.getUserDtype().equals("Shopper")) {
				return "front/shopper_info";
			} else if (currentUser.getUserDtype().equals("Admin")) {
				return "front/admin";
			} else {
				return "front/register";
			}
		}
	}
	@RequestMapping(value = "/show/order", method = RequestMethod.GET)
	public String showOrder(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("show order");
		User user = (User) session.getAttribute("currentUser");
		if (user == null) {
			return "front/failed";
		} else {
			int cid = user.getId();
			Order order = orderDao.findOrderByCid(cid);
			if (order == null) {
				return "front/failed";
			} else {
				int id = order.getId();
				String date = order.getDate();
				int sum = order.getSum();
//				request.setAttribute("orderNumber", orderNumber);
				request.setAttribute("id", id);
				request.setAttribute("date", date);
				request.setAttribute("sum", sum);
				return "front/order_info";
			}
		}
	}
	
	
	@RequestMapping(value = "/user/updateUser", method = RequestMethod.POST)
	public String customerUpdateCustomer(Model model, HttpServletRequest request, HttpSession session) {
		User currentUser = (User) session.getAttribute("currentUser");
		String newUserRole = request.getParameter("userDtype");
		currentUser.setUserDtype(newUserRole);
		if (newUserRole != null && newUserRole.equals("Customer")) {
			currentUser.setUserDtype(newUserRole);
			return "front/customer_info";
		} else if (newUserRole != null && newUserRole.equals("Shopper")) {
			currentUser.setUserDtype(newUserRole);
			return "front/shopper_info";
		} else {
			return "front/failed";
		}
	}
	
	@RequestMapping(value = "/view/shopper", method = RequestMethod.POST)
	public String showShopper(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("show user");
		User user = (User) session.getAttribute("currentUser");
		if (user == null) {
			return "front/failed";
		} else {
			int cid = user.getId();
			Order order = orderDao.findOrderByCid(cid);
			if (order == null) {
				return "front/failed";
			} else {
				int sid = order.getSid();
				Shopper shopper = shopperDao.findShopperById(sid);
				int oid = order.getId();
				String role = shopper.getUserDtype();
				String shopperName = shopper.getFirstName();
				String shopperEmail = shopper.getEmail();
				String phone = shopper.getPhone();
//				request.setAttribute("orderNumber", orderNumber);
				request.setAttribute("oid", oid);
				request.setAttribute("sid", sid);
				request.setAttribute("role", role);
				request.setAttribute("shopperName", shopperName);
				request.setAttribute("shopperEmail", shopperEmail);
				request.setAttribute("shopperPhone", phone);
				return "front/order_shopper";
			}
		}
	}

	// Click logout button -> register.jsp
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String sayCustomer(HttpSession session) {
		ModelAndView model = new ModelAndView("test");
		System.out.println("Hi Customer!");
		Customer c = customerDao.findCustomerById(1);
		model.addObject("firstName", c.getFirstName());
		model.addObject("lastName", c.getLastName());
		model.addObject("email", c.getEmail());
		model.addObject("phone", c.getPhone());
		return "front/register";
	}

	// register Customer/Shopper -> customer_info.jsp/shopper_info.jsp
	// register other -> register failed
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(Model model, HttpServletRequest request, HttpSession session) {
		String userRole = request.getParameter("userRole");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		System.out.println("createser");
		System.out.println(userRole);
		if (userRole != null && userRole.equals("Customer")) {
			Customer customer = new Customer(email, firstName, lastName, password, phone, userRole, true, false);
			customerDao.createCustomer(customer);
			session.setAttribute("currentUser", customer);
			return "front/customer_info";
		} else if (userRole != null && userRole.equals("Shopper")) {
			Shopper shopper = new Shopper(firstName, lastName, password, email, phone, userRole, true, false, 0);
			shopperDao.createShopper(shopper);
			session.setAttribute("currentUser", shopper);
			return "front/shopper_info";
		} else {
			return "front/register";
		}
	}

	// test 1: customer review shopper
	 @RequestMapping(value = "/createReview", method = RequestMethod.POST)
	 public String createReview(Model model, HttpServletRequest request, HttpSession session) {
	  String email = request.getParameter("email");
	  String productNumber = request.getParameter("productNumber");
	  String description = request.getParameter("description");
	  String rate = request.getParameter("rate");
	  System.out.println("create review");
	  Shopper shopper = shopperDao.findShopperByEmail(email);
	  if (shopper != null) {
		  Review review = new Review(productNumber, description, rate);
		  shopperDao.addReviewToShopper(review, shopper);
		  return "front/success";
	  } else {
		  return "front/failed";
	  }
	 }

//	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
//	public String addReview(HttpServletRequest request, HttpSession session) {
//		System.out.println("/addReview");
//		User currentUser = (User) session.getAttribute("currentUser");
//		String reviewId = request.getParameter("reviewId");
//		request.setAttribute("reviews", reviewRepository.findAll());
//		if (reviewId != null) {
//			Review thisReview = reviewRepository.findById(Integer.parseInt(reviewId)).get();
//			Shopper thisshopper = shopperDao.findShopperById(currentUser.getId());
//			shopperDao.addReviewToShopper(thisReview, thisshopper);
//			return "redirect/shopper";
//		}
//		return "addReview";
////			request.getRequestDispatcher("View.jsp").forward(request, response);
//	}
	
	//add item to shopping cart
	@RequestMapping(value = "/addItems", method = RequestMethod.POST)
	public String addItemsToShoppingCart(Model model, HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("product");
		System.out.println("add");
		Product product = productDao.findProductByName(name);
		if (product == null) {
			return "front/failed";
		} else {
			return "front/shopping_cart";
		}
	}

	// test 3 : costumer can see details of the product

	// test 4 : profile
	@GetMapping("/select/all")
	public List<Items> getAllItems() {
		return (List<Items>) itemsRepository.findAll();
	}

	// test 5 : customer reviews all shopper

	// test 6 : add Order to shoppingCart
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String addOrder(HttpServletRequest request, HttpSession session) {
		System.out.println("/addOrder");
		User currentUser = (User) session.getAttribute("currentUser");
		String orderId = request.getParameter("orderId");
		request.setAttribute("orders", orderDao.findOrderById(Integer.parseInt(orderId)));
		if (orderId != null) {
			Order thisOrder = orderDao.findOrderById(Integer.parseInt(orderId));
			ShoppingCart shoppingCart = shoppingCartRepository.findById(currentUser.getId()).get();
			shoppingCartDao.placeOrder(shoppingCart, thisOrder);
			return "redirect:/shoppingCart";
		}
		return "addOrder";
	}

	// test 7: domain to domain
	@PostMapping("api/shoppingCart/{sid}/items/{iid}")
	public ShoppingCart addItemsToShoppingCart(@PathVariable("sid") int sid, @PathVariable("iid") int iid) {
		ShoppingCart shoppingCart = shoppingCartRepository.findById(sid).get();
		Items items = shoppingCartDao.findItemsById(iid);
		return shoppingCartDao.addItemsToShoppingCart(shoppingCart, items);
	}

	// test 8 : an admin create a user
//	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
//	public String createUser(Model model, HttpServletRequest request, HttpSession session) {
//		String userRole = request.getParameter("userRole");
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		String phone = request.getParameter("phone");
//		int tips = request.getIntHeader("tips");
//		System.out.println("createser");
//		System.out.println(userRole);
//		if (userRole != null && userRole.equals("Customer")) {
//			Customer customer = new Customer(firstName, lastName, password, email, phone, userRole, false, false);
//			customerDao.createCustomer(customer);
//			return "redirect:/admin";
//		} else if (userRole != null && userRole.equals("Seller")) {
//			Seller seller = new Seller(firstName, lastName, password, email, phone, userRole, false, false);
//			sellerDao.createSeller(seller);
//			return "redirect:/admin";
//		} else if (userRole != null && userRole.equals("Shopper")) {
//			Shopper shopper = new Shopper(firstName, lastName, password, email, phone, userRole, false, false, tips);
//			shopperDao.createShopper(shopper);
//			return "redirect:/admin";
//		} else if (userRole != null && userRole.contentEquals("Admin")) {
//			Admin admin = new Admin(firstName, lastName, password, email, phone, userRole);
//			adminDao.createAdmin(admin);
//			return "redirect:/admin";
//		}
//		return "createuser";
//	}

	// test 9 : an admin lists all users
	@GetMapping("/api/user")
	public Iterable<User> findAllUsers() {
		Iterable<User> user = userDao.findAllUsers();
		return user;
	}

	// test 11 : an admin removes a user
	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public String adminDeleteUser(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("/deleteuser");
		String id = request.getParameter("id");
		if (id != null) {
			adminDao.deleteUserById(Integer.parseInt(id));
			return "redirect:/admin";
		}
		return "deleteuser";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String welcomeAdmin(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("/admin");
		User currentUser = (User) session.getAttribute("currentUser");
		List<User> users = userDao.findAllUsers();
		// model.addAttribute("message", currentUser.getEmail());
		// model.addAttribute("test", "Goodbye Word");

		// ModelAndView modelN = new ModelAndView("admin");
		request.setAttribute("users", users);
		request.setAttribute("firstName", currentUser.getFirstName());
		request.setAttribute("lastName", currentUser.getLastName());
		// modelN.addObject("users", users);
		// modelN.addObject("firstName", currentUser.getFirstName());
		// modelN.addObject("lastName", currentUser.getLastName());
		return "admin";// modelN;
	}
}
