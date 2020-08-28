package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Seller;

public interface SellerRepository extends CrudRepository<Seller, Integer>{
	@Query("SELECT s from Seller s WHERE s.email=:email AND s.password=:password")
	public Seller findSellerByCredentials(
			@Param("email") String email, @Param("password") String password);
	
	@Query("SELECT s FROM Seller s Where s.email=:email")
	public Seller findSellerByEmail(@Param("email") String email);
}
