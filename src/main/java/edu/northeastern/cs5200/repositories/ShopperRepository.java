package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Shopper;

public interface ShopperRepository extends CrudRepository<Shopper, Integer>{
	@Query("SELECT s from Shopper s WHERE s.email=:email AND s.password=:password")
	public Shopper findShopperByCredentials(
			@Param("email") String email, @Param("password") String password);
	
	@Query("SELECT s FROM Shopper s Where s.email=:email")
	public Shopper findShopperByEmail(@Param("email") String email);
}
