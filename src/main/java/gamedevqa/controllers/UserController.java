package gamedevqa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private List<User> users = new ArrayList<User>();
	
	@RequestMapping(method=RequestMethod.POST)
	public void addUser(@RequestBody User newUser) {
		users.add(newUser);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
		User existingUser = users.stream().filter(x -> x.getId() == user.getId()).findFirst().orElse(null);
		existingUser.copy(user);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable int id) {
		User userToRemove = users.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		users.remove(userToRemove);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public User retrieveUser(@PathVariable int id) {
		return users.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> retrieveUsers() {
		return users;
	}

}
