package gamedevqa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Priority;

@RestController
@RequestMapping("/priorities")
public class PriorityController {
	
	private List<Priority> priorities = new ArrayList<Priority>();
	
	public PriorityController() {
		Priority priority1 = new Priority();
		priority1.setId(1);
		priority1.setDescription("Low");
		priorities.add(priority1);
		Priority priority2 = new Priority();
		priority2.setId(2);
		priority2.setDescription("Critical");
		priorities.add(priority2);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Priority retrievePriority(@PathVariable int id) {
		return priorities.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Priority> retrievePriorities() {
		return priorities;
	}

}