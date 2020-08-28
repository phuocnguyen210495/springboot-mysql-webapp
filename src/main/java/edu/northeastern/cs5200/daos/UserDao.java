package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.User;
//import edu.northeastern.cs5200.models.UserRole;
import edu.northeastern.cs5200.repositories.UserRepository;

@Controller("UserDao")
public class UserDao {
	
	@Autowired
	UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public User findUserById(int id) {
		User u = (User) userRepository.findById(id).get();
		return u;
	}
	public User findUserByEmail(String email) {
		User user = userRepository.findUserByEmail(email);
		return user;
	}
	
	public void deleteAllUsers(){
		userRepository.deleteAll();
	}
	
	public void deleteUserById(int id){
		userRepository.deleteById(id);
	}	
	
}
