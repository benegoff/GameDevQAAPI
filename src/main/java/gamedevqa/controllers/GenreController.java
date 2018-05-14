package gamedevqa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Genre;

@RestController
@RequestMapping("/genres")
public class GenreController {
	
	private List<Genre> genres = new ArrayList<Genre>();
	
	public GenreController() {
		Genre genre1 = new Genre();
		genre1.setId(1);
		genre1.setName("RPG");
		genres.add(genre1);
		Genre genre2 = new Genre();
		genre2.setId(2);
		genre2.setName("FPS");
		genres.add(genre2);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Genre retrieveGenre(@PathVariable int id) {
		return genres.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Genre> retrieveGenres() {
		return genres;
	}

}