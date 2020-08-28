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
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.Shopper;
import edu.northeastern.cs5200.models.ShoppingCart;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.ItemsRepository;
import edu.northeastern.cs5200.repositories.ReviewRepository;
import edu.northeastern.cs5200.repositories.ShoppingCartRepository;

@Controller
public class OrderController {
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
	
	// test 2 :search products
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchProductByName(Model model, HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("product");
		System.out.println("search");
		Product product = productDao.findProductByName(name);
		session.setAttribute("currentProduct", product);
		if (product == null) {
			return "front/failed";
		} else {
			String description = product.getDescription();
//			String productNumber = product.getProductNumber();
			int price = product.getPrice();
			int salesVolume = product.getSalesVolume();
			request.setAttribute("name", name);
			request.setAttribute("description", description);
//			request.setAttribute("productNumber", productNumber);
			request.setAttribute("price", price);
			request.setAttribute("salesVolume", salesVolume);
			return "front/product";
		}
	}
	
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("add to cart");
		User user = (User) session.getAttribute("currentUser");
		Product product = (Product) session.getAttribute("currentProduct");
		int productQty = Integer.parseInt(request.getParameter("productQty"));
		int pid = product.getId();
//		System.out.println(product.getName());
//		System.out.println("done");
		String productName = product.getName();
		int productPrice = product.getPrice();
		int productSum = productPrice * productQty;
		request.setAttribute("productName", productName);
		request.setAttribute("productPrice", productPrice);
		request.setAttribute("productQty", productQty);
		request.setAttribute("productSum", productSum);
		ShoppingCart shoppingCart = new ShoppingCart(pid, productName, productQty, productSum);
		shoppingCartDao.createShoppingCart(shoppingCart);
		List<ShoppingCart> items = shoppingCartDao.findAllShoppingCart();
		session.setAttribute("items", items);
		session.setAttribute("productSum", productSum);
		if (user == null) {
			return "front/failed";
		} else if (user.getUserDtype().equals("Customer")) {
			return "front/shopping_cart";
		} else {
			return "front/failed";
		}
	}
	
//	@RequestMapping(value = "/view/shoppingCart", method = RequestMethod.POST)
//	public String viewShoppingCart(Model model, HttpServletRequest request, HttpSession session) {
//		List<ShoppingCart> items = shoppingCartDao.findAllShoppingCart();
//		request.setAttribute("items", items);
//		return "front/shopping_cart";
//	}
	
	@RequestMapping(value = "/emptyCart", method = RequestMethod.POST)
	public String emptyShoppingCart(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("delete all items");
		shoppingCartDao.emptyShoppingCart();
		List<ShoppingCart> items = shoppingCartDao.findAllShoppingCart();
		session.setAttribute("items", items);
		return "front/shopping_cart";
	}
	
	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	public String placeOrder(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("placeOrder");
		List<ShoppingCart> items = (List<ShoppingCart>)session.getAttribute("items");
		int sum = 0;
		for (ShoppingCart item : items) {
			int productSum = item.getProductSum();
			sum += productSum;
		}
		User user = (User) session.getAttribute("currentUser");
		String customerName = user.getFirstName();
		request.setAttribute("customerName", customerName);
		request.setAttribute("orderSum", sum);
		
		return "front/place_order";
	}
	
	
}
