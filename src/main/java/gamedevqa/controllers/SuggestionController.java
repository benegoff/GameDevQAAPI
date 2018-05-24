package gamedevqa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Suggestion;
import gamedevqa.repos.SuggestionJpaRepository;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {
	
	@Autowired
	private SuggestionJpaRepository suggestionRepo;
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public void addSuggestion(@RequestBody Suggestion newSuggestion) {
		suggestionRepo.saveAndFlush(newSuggestion);
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.PUT)
	public void updateSuggestion(@RequestBody Suggestion suggestion) {
		Suggestion existingSuggestion = suggestionRepo.findById(suggestion.getId()).orElse(null);
		existingSuggestion.copy(suggestion);
		suggestionRepo.saveAndFlush(existingSuggestion);
	}
	
	@Transactional
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteSuggestion(@PathVariable int id) {
		suggestionRepo.deleteById(id);
	}
	
	@Transactional
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Suggestion retrieveSuggestion(@PathVariable int id) {
		return suggestionRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Suggestion> retrieveSuggestions() {
		return suggestionRepo.findAll();
	}

}