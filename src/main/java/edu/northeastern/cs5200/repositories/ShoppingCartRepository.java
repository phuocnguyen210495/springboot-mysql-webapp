package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer>{
	@Query("SELECT s FROM ShoppingCart s Where s.customerName=:customerName")
	public Product findShoppingCartByCustomerName(@Param("customerName") String customerName);

}
