package gamedevqa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Bug;
import gamedevqa.repos.BugJpaRepository;

@RestController
@RequestMapping("/bugs")
public class BugController {
	
	@Autowired
	private BugJpaRepository bugRepo;
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public void addBug(@RequestBody Bug newBug) {
		bugRepo.saveAndFlush(newBug);
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.PUT)
	public void updateBug(@RequestBody Bug bug) {
		Bug existingBug = bugRepo.findById(bug.getId()).orElse(null);
		existingBug.copy(bug);
		bugRepo.saveAndFlush(existingBug);
	}
	
	@Transactional
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteBug(@PathVariable int id) {
		bugRepo.deleteById(id);
	}
	
	@Transactional
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Bug retrieveBug(@PathVariable int id) {
		return bugRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Bug> retrieveBugs() {
		return bugRepo.findAll();
	}

}
