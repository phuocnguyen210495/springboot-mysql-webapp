package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.Items;
import edu.northeastern.cs5200.models.Order;
//import edu.northeastern.cs5200.models.Order;
import edu.northeastern.cs5200.models.ShoppingCart;
import edu.northeastern.cs5200.repositories.ItemsRepository;
import edu.northeastern.cs5200.repositories.OrderRepository;
//import edu.northeastern.cs5200.repositories.OrderRepository;
import edu.northeastern.cs5200.repositories.ShoppingCartRepository;

@Controller("ShoppingCartDao")
public class ShoppingCartDao {
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	@Autowired
	ItemsRepository itemsRepository;
	@Autowired
	OrderRepository orderRepository;
	
	public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
		return shoppingCartRepository.save(shoppingCart);
	}
	
	public ShoppingCart addItemsToShoppingCart(ShoppingCart shoppingCart, Items items){
    	shoppingCart.itemsOfshoppingCart(items);
    	itemsRepository.save(items);
    	return shoppingCartRepository.save(shoppingCart);

    }
	
	public void deleteItemsFromShoppingCart(ShoppingCart shoppingCart, Items items){
    	shoppingCart.removeItemsOfshoppingCart(items);
    	itemsRepository.save(items);
    	shoppingCartRepository.save(shoppingCart);
    }
	
	public void deleteAllItems() {
		itemsRepository.deleteAll();
	}
	
	public void deleteItemsById(int id) {
		itemsRepository.deleteById(id);
	}
	
	public List<Items> findAllItems() {
		List<Items> items = (List<Items>) itemsRepository.findAll();
		return items;
	}
	
	public List<ShoppingCart> findAllShoppingCart() {
		List<ShoppingCart> items = (List<ShoppingCart>) shoppingCartRepository.findAll();
		return items;
	}
	
	public void emptyShoppingCart() {
		shoppingCartRepository.deleteAll();
	}
	
	public Items findItemsById(int id) {
		Items i = (Items) itemsRepository.findById(id).get();
		return i;
	}
	
	public ShoppingCart placeOrder(ShoppingCart shoppingCart, Order order) {
		shoppingCart.orderOfshoppingCart(order);
		orderRepository.save(order);
		return shoppingCartRepository.save(shoppingCart);
	};
}
