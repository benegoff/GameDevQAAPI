package gamedevqa.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Genre;
import gamedevqa.repos.GenreJpaRepository;

@RestController
@RequestMapping("/genres")
public class GenreController {
	
	private GenreJpaRepository genreRepo;
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Genre retrieveGenre(@PathVariable int id) {
		return genreRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Genre> retrieveGenres() {
		return genreRepo.findAll();
	}

}