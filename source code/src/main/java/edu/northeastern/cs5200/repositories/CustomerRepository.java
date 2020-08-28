package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	@Query("SELECT c from Customer c WHERE c.email=:email AND c.password=:password")
	public Customer findCustomerByCredentials(
			@Param("email") String email, @Param("password") String password);
	
	@Query("SELECT c FROM Customer c Where c.email=:email")
	public Customer findCustomerByEmail(@Param("email") String email);
}
