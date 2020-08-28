package edu.northeastern.cs5200.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Order;
import edu.northeastern.cs5200.models.Shopper;

public interface OrderRepository extends CrudRepository<Order, Integer>{
	@Query("SELECT o FROM Order o WHERE o.date=:date ")
	public Order findOrderByDate(@Param("date") Date date);
	
	@Query("SELECT o FROM Order o WHERE o.thisCustomerOrder=:thisCustomerOrder ")
	public Order findOrderByCustomer(@Param("thisCustomerOrder") Customer thisCustomerOrder);
	
	@Query("SELECT o FROM Order o WHERE o.thisShopperOrder=:thisShopperOrder ")
	public Order findOrderByShopper(@Param("thisShopperOrder") Shopper thisShopperOrder);
	
//	@Query("SELECT o FROM Order o Where o.orderNumber=:orderNumber")
//	public Order findOrderByOrderNumber(@Param("orderNumber") String orderNumber);
	@Query("SELECT o FROM Order o Where o.cid=:cid")
	public Order findOrderByCid(@Param("cid") int cid);
}
