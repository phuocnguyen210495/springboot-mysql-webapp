package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.northeastern.cs5200.models.Items;
import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.Review;
import edu.northeastern.cs5200.repositories.ItemsRepository;
import edu.northeastern.cs5200.repositories.ProductRepository;
import edu.northeastern.cs5200.repositories.ReviewRepository;

@Controller("ProductDao")
public class ProductDao {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	ItemsRepository itemsRepository;
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteAllProducts() {
		productRepository.deleteAll();
	}
	
	public void deleteProductById(int pid) {
		productRepository.deleteById(pid);
	}
	
	public List<Product> findAllProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}
	
	public Product findProductById(int pid) {
		Product p = (Product) productRepository.findById(pid).get();
		return p;
	}
	
	public Product findProductByName(String name) {
		Product product = productRepository.findProductByName(name);
		return product;
	}
	
//	public Product findProductByProductNumber(String productNumber) {
//		Product product = productRepository.findProductByProductNumber(productNumber);
//		return product;
//	}
	
	public Product updateProduct(int id, Product product) {
		Product p = (Product) productRepository.findById(id).get();
		p.setName(product.getName());
		p.setDescription(product.getDescription());
//		p.setProductNumber(product.getProductNumber());
		p.setPrice(product.getPrice());
		p.setSalesVolume(product.getSalesVolume());
		productRepository.save(p);
		return p;
	}
	
	public Product addItemsToProduct(Items items, Product product) {
		product.itemsOfThisProduct(items);
		itemsRepository.save(items);
		return productRepository.save(product);
	}
	
	public void deleteItemsFromProduct(Items items, Product product){
    	product.removeItemsForThisProduct(items);
    	productRepository.save(product);
    	itemsRepository.save(items);
    }
	
	public Product addReviewToProduct(Review reviews, Product product) {
		product.reviewForThisProduct(reviews);
		reviewRepository.save(reviews);
		return productRepository.save(product);
	}
	
	public void deleteReviewFromProduct(Review reviews, Product product){
    	product.removeReviewForThisProduct(reviews);
    	productRepository.save(product);
    	reviewRepository.save(reviews);
    }
}
