//package edu.northeastern.cs5200.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import edu.northeastern.cs5200.daos.ShopperDao;
//import edu.northeastern.cs5200.models.Shopper;
//
//@Controller
//public class ShopperController {
//	@Autowired
//	ShopperDao shopperDao;
//	
//	@PostMapping("/api/shopper/{shid}")
//	public Shopper createShopper(@RequestBody Shopper shopper) {
//		return shopperDao.createShopper(shopper);
//	}
//	
//	@GetMapping("/api/shopper")
//	public Iterable<Shopper> findAllShopper(){
//		Iterable<Shopper> shopper = shopperDao.findAllShoppers();
//		return shopper;
//	}
//	
//	@GetMapping("/api/shopper/{shid}")
//	public Shopper findShopperById(@PathVariable("shid") int shid) {
//		Shopper shopper = shopperDao.findShopperById(shid);
//		return shopper;
//	}
//	
//	@GetMapping("/api/shopper/{shid}")
//	public Shopper findShopperByEmail(@PathVariable("email") String email) {
//		Shopper shopper = shopperDao.findShopperByEmail(email);
//		return shopper;
//	}
//	
//	@DeleteMapping("/api/shopper/{shid}") 
//	public void deleteShopperById(@PathVariable("shid") int id) {
//		shopperDao.deleteShopperById(id);
//	}
//	
//	@PutMapping("/api/shopper/{shid}")
//	public Shopper updateShopper(@PathVariable("shid") int id, @RequestBody Shopper s) {
//		Shopper shopper = shopperDao.updateShopper(id, s);
//		return shopper;
//	}
//	
//	
//
//}
