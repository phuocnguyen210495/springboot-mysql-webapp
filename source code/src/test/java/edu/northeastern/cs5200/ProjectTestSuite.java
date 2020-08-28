package edu.northeastern.cs5200;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.daos.AdminDao;
import edu.northeastern.cs5200.daos.CustomerDao;
import edu.northeastern.cs5200.daos.OrderDao;
import edu.northeastern.cs5200.daos.ProductDao;
import edu.northeastern.cs5200.daos.SellerDao;
import edu.northeastern.cs5200.daos.ShopperDao;
import edu.northeastern.cs5200.models.Admin;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Order;
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.Seller;
import edu.northeastern.cs5200.models.Shopper;
import edu.northeastern.cs5200.repositories.CustomerRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectTestSuite {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	SellerDao sellerDao;
	@Autowired
	AdminDao adminDao;
	@Autowired 
	ProductDao productDao;
	@Autowired
	ShopperDao shopperDao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void InsertData() {
		System.out.println("CREATE CUSTOMER");
		Customer alan = new Customer("alan", "wonderland", "123", "alan@gmail.com", "617-xxxxxxx", "Customer", true, false);
		customerDao.createCustomer(alan);
		Customer bob= new Customer("bob", "dylan", "234", "bob@gmail.com", "617-xxxxxxx", "Customer", true, false);
		customerDao.createCustomer(bob);
		Customer charlie= new Customer("charlie", "charles", "345", "charlie@gmail.com", "617-xxxxxxx", "Customer", true, false);
		customerDao.createCustomer(charlie);
		
		Shopper dan= new Shopper("dan", "dan", "456", "dan@gmail.com", "617-xxxxxxx", "Shopper", true, false, 0);
		shopperDao.createShopper(dan);
		Shopper ed= new Shopper("ed", "ed", "567", "ed@gmail.com", "617-xxxxxxx", "Shopper", true, false, 0);
		shopperDao.createShopper(ed);
		
		System.out.println("CREATE SELLER");
		Seller starMarket = new Seller("star", "market", "111", "starMarket@gmail.com", "617-xxxxxxx", "Seller", true, false);
		sellerDao.createSeller(starMarket);
		Seller wholeFoods = new Seller("whole", "foods", "111", "wholeFoods@gmail.com", "617-xxxxxxx", "Seller", true, false);
		sellerDao.createSeller(wholeFoods);
		
		System.out.println("CREATE ADMIN");
		Admin admin = new Admin("admin", "admin", "000", "admin@gmail.com", "617-xxxxxxx", "Admin");
		adminDao.createAdmin(admin);
		
		System.out.println("ADD PRODUCT");
		Product apple = new Product("apple", "Apple is a very delicious fruit", 2, 1000);
		productDao.createProduct(apple);
		Product banana = new Product("banana", "Banana is a very delicious fruit", 1, 1000);
		productDao.createProduct(banana);
		Product milk = new Product("milk", "Milk is very tasty", 3, 1000);
		productDao.createProduct(milk);
		
		System.out.println("PLACE ORDER");
		Order order = new Order("21Apr", 99, 1, 4);
		orderDao.createOrder(order);
		
		
	}
}
