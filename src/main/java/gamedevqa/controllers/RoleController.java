package gamedevqa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Role;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
private List<Role> roles = new ArrayList<Role>();
	
	public RoleController() {
		Role role1 = new Role();
		role1.setId(1);
		role1.setName("User");
		roles.add(role1);
		Role role2 = new Role();
		role2.setId(2);
		role2.setName("Admin");
		roles.add(role2);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Role retrieveRole(@PathVariable int id) {
		return roles.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Role> retrieveRoles() {
		return roles;
	}

}