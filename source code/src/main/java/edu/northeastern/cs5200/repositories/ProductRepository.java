package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	@Query("SELECT p FROM Product p Where p.name=:name")
	public Product findProductByName(@Param("name") String name);
	
//	@Query("SELECT p FROM Product p Where p.productNumber=:productNumber")
//	public Product findProductByProductNumber(@Param("productNumber") String productNumber);

}
