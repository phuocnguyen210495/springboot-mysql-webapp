package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Review;
//import edu.northeastern.cs5200.models.Order;
import edu.northeastern.cs5200.models.Shopper;
import edu.northeastern.cs5200.repositories.ReviewRepository;
//import edu.northeastern.cs5200.repositories.OrderRepository;
import edu.northeastern.cs5200.repositories.ShopperRepository;

@Controller("ShopperDao")
public class ShopperDao {
	@Autowired
	ShopperRepository shopperRepository;
	@Autowired
	ReviewRepository reviewRepository;
//	@Autowired
//	OrderRepository orderRepository;
	
	public Shopper createShopper(Shopper shopper) {
		return shopperRepository.save(shopper);
	}
	
	public void deleteAllShoppers() {
		shopperRepository.deleteAll();
	}
		
	public void deleteShopperById(int id) {
		shopperRepository.deleteById(id);
	}
		
	public Shopper findShopperById(int id) {
		Shopper s = (Shopper) shopperRepository.findById(id).get();
		return s;
	}
		
	public List<Shopper> findAllShoppers() {
		List<Shopper> shoppers = (List<Shopper>) shopperRepository.findAll();
		return shoppers;
	}
		
	public Shopper findShopperByCredentials(String email, String password) {
		Shopper shopper = shopperRepository.findShopperByCredentials(email, password);
		return shopper;
	}
	
	public Shopper findShopperByEmail(String email) {
		Shopper shopper = shopperRepository.findShopperByEmail(email);
		return shopper;
	}
		
	public Shopper updateShopper(int id, Shopper shopper) {
		Shopper s = (Shopper) shopperRepository.findById(id).get();
		s.setEmail(shopper.getEmail());
		s.setFirstName(shopper.getFirstName());
		s.setLastName(shopper.getLastName());
		s.setPassword(shopper.getPassword());
		shopperRepository.save(s);
		return s;
	}
	//review
	public Shopper addReviewToShopper(Review reviews, Shopper shopper) {
		shopper.reviewForThisShopper(reviews);;
		reviewRepository.save(reviews);
		return shopperRepository.save(shopper);
	}
	
	public void deleteReviewFromShopperr(Review reviews, Shopper shopper){
		shopper.removeReviewFromThisShopper(reviews);
		shopperRepository.save(shopper);
    	reviewRepository.save(reviews);
    }

	
	
////	order
//	public Shopper addOrderToShopper(Order order, Shopper shopper) {
//		shopper.orderForThisShopper(order);
//		orderRepository.save(order);
//		return shopperRepository.save(shopper);
//	}
//	
//	public void deleteOrderFromShopper(Order order, Shopper shopper){
//    	shopper.removeOrderForThisShopper(order);
//    	shopperRepository.save(shopper);
//    	orderRepository.save(order);
//    }
	
//	public Shopper addTipsToShopper(Shopper shopper, Order order) {
//		int sum = order.getSum();
//		int tips = (sum * 5) / 100;
//		shopper.setTips(tips);
//		return shopperRepository.save(shopper);
//	}
	
	public Shopper activeShopper(Shopper shopper){
		shopper.setActive(true);
		shopperRepository.save(shopper);
    	return shopperRepository.save(shopper);
    }
	
	public Shopper blockShopper(Shopper shopper){
		shopper.setBlocked(true);
		shopperRepository.save(shopper);
    	return shopperRepository.save(shopper);
    }

}
