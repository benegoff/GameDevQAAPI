package gamedevqa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.User;
import gamedevqa.repos.UserJpaRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserJpaRepository userRepo;
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public void addUser(@RequestBody User newUser) {
		userRepo.saveAndFlush(newUser);
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
		User existingUser = userRepo.findById(user.getId()).orElse(null);
		existingUser.copy(user);
		userRepo.saveAndFlush(existingUser);
	}
	
	@Transactional
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable int id) {
		userRepo.deleteById(id);
	}
	
	@Transactional
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public User retrieveUser(@PathVariable int id) {
		return userRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> retrieveUsers() {
		return userRepo.findAll();
	}

}
