package gamedevqa.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Game;
import gamedevqa.repos.GameJpaRepository;

@RestController
@RequestMapping("/games")
public class GameController {

	@Autowired
	private GameJpaRepository gameRepo;
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public void addGame(@RequestBody Game newGame) {
		gameRepo.saveAndFlush(newGame);
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.PUT)
	public void updateGame(@RequestBody Game game) {
		Game existingGame = gameRepo.findById(game.getId()).orElse(null);
		existingGame.copy(game);
		gameRepo.saveAndFlush(existingGame);
	}
	
	@Transactional
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteGame(@PathVariable int id) {
		gameRepo.deleteById(id);
	}
	
	@Transactional
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Game retrieveGame(@PathVariable int id) {
		return gameRepo.findById(id).orElse(null);
	}
	
	@Transactional
	@RequestMapping(path="/genre/{id}", method=RequestMethod.GET)
	public List<Game> retrieveGamesByGenre(@PathVariable Integer id) {
		return gameRepo.findAll().stream().filter(x -> x.getGenre().getId() == id).collect(Collectors.toList());
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Game> retrieveGames() {
		return gameRepo.findAll();
	}

}
