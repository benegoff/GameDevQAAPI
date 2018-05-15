package gamedevqa.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Role;
import gamedevqa.repos.RoleJpaRepository;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	private RoleJpaRepository roleRepo;
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Role retrieveRole(@PathVariable int id) {
		return roleRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Role> retrieveRoles() {
		return roleRepo.findAll();
	}

}