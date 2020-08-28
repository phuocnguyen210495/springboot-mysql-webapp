package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.Seller;
import edu.northeastern.cs5200.repositories.AddressRepository;
import edu.northeastern.cs5200.repositories.ProductRepository;
import edu.northeastern.cs5200.repositories.SellerRepository;

@Controller("SellerDao")
public class SellerDao {
	@Autowired
	SellerRepository sellerRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	ProductRepository productRepository;
	
	public Seller createSeller(Seller seller) {
		return sellerRepository.save(seller);
	}
	
	public void deleteAllSellers() {
		sellerRepository.deleteAll();
	}
		
	public void deleteSellerById(int id) {
		sellerRepository.deleteById(id);
	}
		
	public Seller findSellerById(int id) {
		Seller s = (Seller) sellerRepository.findById(id).get();
		return s;
	}
		
	public List<Seller> findAllSellers() {
		List<Seller> sellers = (List<Seller>) sellerRepository.findAll();
		return sellers;
	}
		
	public Seller findSellerByCredentials(String email, String password) {
		Seller seller = sellerRepository.findSellerByCredentials(email, password);
		return seller;
	}
	
	public Seller findSellerByEmail(String email) {
		Seller seller = sellerRepository.findSellerByEmail(email);
		return seller;
	}
		
	public Seller updateSeller(int id, Seller seller) {
		Seller s = (Seller) sellerRepository.findById(id).get();
		s.setEmail(seller.getEmail());
		s.setFirstName(seller.getFirstName());
		s.setLastName(seller.getLastName());
		s.setPassword(seller.getPassword());
		sellerRepository.save(s);
		return s;
	}
	
	public Seller addAddressToSeller(Address address, Seller seller) {
		seller.addressForSeller(address);
		addressRepository.save(address);
		return sellerRepository.save(seller);
	}
	
	public void deleteAddressFromSeller(Address address, Seller seller){
    	seller.removeAddressForSeller(address);
    	sellerRepository.save(seller);
    	addressRepository.save(address);
    }
	
	public Seller addProduct(Product products, Seller seller) {
		seller.productManagedByThisSeller(products);
		productRepository.save(products);
		return sellerRepository.save(seller);
	}
	
	public void deleteProduct(Product products, Seller seller){
    	seller.removeProductManagedByThisSeller(products);
    	sellerRepository.save(seller);
    	productRepository.save(products);
    }
	
	public Seller activeSeller(Seller seller){
    	seller.setActive(true);
    	sellerRepository.save(seller);
    	return sellerRepository.save(seller);
    }
	
	public Seller blockSeller(Seller seller){
    	seller.setBlocked(true);
    	sellerRepository.save(seller);
    	return sellerRepository.save(seller);
    }
}
