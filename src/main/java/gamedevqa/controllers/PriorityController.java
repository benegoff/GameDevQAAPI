package gamedevqa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Priority;
import gamedevqa.repos.PriorityJpaRepository;

@RestController
@RequestMapping("/priorities")
public class PriorityController {
	
	@Autowired
	private PriorityJpaRepository priorityRepo;
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Priority retrievePriority(@PathVariable int id) {
		return priorityRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Priority> retrievePriorities() {
		return priorityRepo.findAll();
	}

}