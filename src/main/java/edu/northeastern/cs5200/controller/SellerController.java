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
//import org.springframework.web.bind.annotation.RestController;
//
//import edu.northeastern.cs5200.daos.ProductDao;
//import edu.northeastern.cs5200.daos.SellerDao;
//import edu.northeastern.cs5200.models.Address;
//import edu.northeastern.cs5200.models.Product;
//import edu.northeastern.cs5200.models.Seller;
//import edu.northeastern.cs5200.repositories.AddressRepository;
//import edu.northeastern.cs5200.repositories.SellerRepository;
//
//@RestController
//public class SellerController {
//	@Autowired
//	SellerDao sellerDao;
//	@Autowired
//	AddressRepository addressRepository;
//	@Autowired
//	SellerRepository sellerRepository;
//	@Autowired
//	ProductDao productDao;
//	
//	@GetMapping("/api/seller")
//	public Iterable<Seller> findAllSeller() {
//		Iterable<Seller> sellers = sellerDao.findAllSellers();
//		return sellers;
//	}
//	
//	@GetMapping("/api/seller/{seid}")
//	public Seller findSellerById(@PathVariable("seid") int seid) {
//		Seller seller = sellerDao.findSellerById(seid);
//		return seller;
//	}
//	
//
//	
//	@DeleteMapping("/api/seller/{seid}") 
//	public void deleteSellerById(@PathVariable("seid") int id) {
//		sellerDao.deleteSellerById(id);
//	}
//	
//	@PutMapping("/api/seller/{seid}")
//	public Seller updateSeller(@PathVariable("seid") int id, @RequestBody Seller s) {
//		Seller seller = sellerDao.updateSeller(id, s);
//		return seller;
//	}
//	
//	@PutMapping("/api/seller")//not sure if it is right
//	public Seller activeSeller(@RequestBody Seller s) {
//		Seller seller = sellerDao.activeSeller(s);
//		return seller;
//	}
//	
//	@PostMapping("/api/seller") 
//	public Seller createSeller(@RequestBody Seller seller) {
//		return sellerDao.createSeller(seller);
//	}
//	
//	@PostMapping("/api/seller/{seid}/address/{aid}")
//	public Seller addAddressToSeller(@PathVariable("seid") int seid, @PathVariable("aid") int aid) {
//		Address address = addressRepository.findById(aid).get();//get by repository
//		Seller seller = sellerRepository.findById(seid).get();
//		return sellerDao.addAddressToSeller(address, seller);
//	}
//	
//	@DeleteMapping("/api/seller/{seid}/address/{aid}")
//	public void delteAddressFromSeller(@PathVariable("seid") int seid, @PathVariable("aid") int aid) {
//		Address address = addressRepository.findById(aid).get();//get by repository
//		Seller seller = sellerRepository.findById(seid).get();
//		sellerDao.deleteAddressFromSeller(address, seller);
//	}
//	
//	@PostMapping("/api/seller/{seid}/product/{pid}")
//	public Seller addProductToSeller(@PathVariable("seid") int seid, @PathVariable("pid") int pid) {
//		Product product = productDao.findProductById(pid);//get by DAO
//		Seller seller = sellerDao.findSellerById(seid);
//		return sellerDao.addProduct(product, seller);
//	}
//	
//	@DeleteMapping("/api/seller/{seid}/product/{pid}")
//	public void deleteProductFromSeller(@PathVariable("seid") int seid, @PathVariable("pid") int pid) {
//		Product product = productDao.findProductById(pid);//get by DAO
//		Seller seller = sellerDao.findSellerById(seid);
//		sellerDao.deleteProduct(product, seller);
//	}
//	
//	
//	
//}
