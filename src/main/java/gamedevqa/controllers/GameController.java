package gamedevqa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Game;
import gamedevqa.models.Genre;

@RestController
@RequestMapping("/games")
public class GameController {
	
	private List<Game> games = new ArrayList<Game>();
	
	@RequestMapping(method=RequestMethod.POST)
	public void addGame(@RequestBody Game newGame) {
		games.add(newGame);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateGame(@RequestBody Game game) {
		Game existingGame = games.stream().filter(x -> x.getId() == game.getId()).findFirst().orElse(null);
		existingGame.copy(game);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteGame(@PathVariable int id) {
		Game gameToRemove = games.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		games.remove(gameToRemove);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Game retrieveGame(@PathVariable int id) {
		return games.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Game> retrieveGameByGenre(@RequestBody Genre genre) {
		return games.stream().filter(x -> x.getGenre().getId() == genre.getId()).collect(Collectors.toList());
	}
	
	@RequestMapping(path="/genre", method=RequestMethod.GET)
	public List<Game> retrieveGames() {
		return games;
	}

}
