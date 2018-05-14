package gamedevqa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Suggestion;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {
	
	private List<Suggestion> suggestions = new ArrayList<Suggestion>();
	
	@RequestMapping(method=RequestMethod.POST)
	public void addSuggestion(@RequestBody Suggestion newSuggestion) {
		suggestions.add(newSuggestion);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateSuggestion(@RequestBody Suggestion suggestion) {
		Suggestion existingSuggestion = suggestions.stream().filter(x -> x.getId() == suggestion.getId()).findFirst().orElse(null);
		existingSuggestion.copy(suggestion);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteSuggestion(@PathVariable int id) {
		Suggestion suggestionToDelete = suggestions.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		suggestions.remove(suggestionToDelete);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Suggestion retrieveSuggestion(@PathVariable int id) {
		return suggestions.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Suggestion> retrieveSuggestions() {
		return suggestions;
	}

}