package gamedevqa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Review;
import gamedevqa.repos.ReviewJpaRepository;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewJpaRepository reviewRepo;
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public void addReview(@RequestBody Review newReview) {
		reviewRepo.saveAndFlush(newReview);
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.PUT)
	public void updateReview(@RequestBody Review review) {
		Review existingReview = reviewRepo.findById(review.getId()).orElse(null);
		existingReview.copy(review);
		reviewRepo.saveAndFlush(review);
	}
	
	@Transactional
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteReview(@PathVariable int id) {
		reviewRepo.deleteById(id);
	}
	
	@Transactional
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Review retrieveReview(@PathVariable int id) {
		return reviewRepo.findById(id).orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Review> retrieveReviews() {
		return reviewRepo.findAll();
	}

}
