package gamedevqa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Bug;

@RestController
@RequestMapping("/bugs")
public class BugController {
	private List<Bug> bugs = new ArrayList<Bug>();
	
	@RequestMapping(method=RequestMethod.POST)
	public void addBug(@RequestBody Bug newBug) {
		bugs.add(newBug);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateBug(@RequestBody Bug bug) {
		Bug existingBug = bugs.stream().filter(x -> x.getId() == bug.getId()).findFirst().orElse(null);
		existingBug.copy(bug);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteBug(@PathVariable int id) {
		Bug bugToRemove = bugs.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		bugs.remove(bugToRemove);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Bug retrieveBug(@PathVariable int id) {
		return bugs.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Bug> retrieveBugs() {
		return bugs;
	}

}
