package gamedevqa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gamedevqa.AmazonClient;
import gamedevqa.models.Game;
import gamedevqa.models.User;
import gamedevqa.repos.GameJpaRepository;
import gamedevqa.repos.UserJpaRepository;

@RestController
@RequestMapping("/uploads/")
public class ImageController {

	@Autowired
	private UserJpaRepository userRepo;
	
	@Autowired
	private GameJpaRepository gameRepo;
	
	private AmazonClient amazonClient;

    @Autowired
    ImageController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }
	
    @Transactional
    @RequestMapping(path="/profileImage/{id}", method=RequestMethod.POST)
    public void uploadProfileImage(@RequestPart(value = "file") MultipartFile file, @PathVariable int id) {
    	User user = userRepo.findById(id).orElse(null);
    	String url = amazonClient.uploadProfileImage(file, user.getUsername());
    	user.setProfileImagePath(url);
    	userRepo.saveAndFlush(user);
    }
    
    @Transactional
    @RequestMapping(path="/screenshot/{id}", method=RequestMethod.POST)
    public void uploadScreenshotToGame(@RequestPart(value = "file") MultipartFile file, @PathVariable int id) {
    	Game game = gameRepo.findById(id).orElse(null);
    	String url = amazonClient.uploadGameScreenshot(file, game.getId());
    	game.getScreenshotLinks().add(url);
    	gameRepo.saveAndFlush(game);
    }
    
    @Transactional
    @RequestMapping(path="/profileImage/{id}", method=RequestMethod.DELETE)
    public String deleteProfileImage(@RequestPart(value = "url") String fileUrl, @PathVariable int id) {
    	User user = userRepo.findById(id).orElse(null);
    	user.setProfileImagePath(null);
    	userRepo.saveAndFlush(user);
    	return amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

    @Transactional
    @RequestMapping(path="/screenshot/{id}", method=RequestMethod.DELETE)
    public String deleteGameScreenshot(@RequestPart(value = "url") String fileUrl, @PathVariable int id) {
    	Game game = gameRepo.findById(id).orElse(null);
    	game.getScreenshotLinks().remove(fileUrl);
    	gameRepo.saveAndFlush(game);
    	return amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
}