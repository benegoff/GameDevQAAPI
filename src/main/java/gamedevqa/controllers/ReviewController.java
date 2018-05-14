package gamedevqa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gamedevqa.models.Review;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	private List<Review> reviews = new ArrayList<Review>();
	
	@RequestMapping(method=RequestMethod.POST)
	public void addReview(@RequestBody Review newReview) {
		reviews.add(newReview);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateReview(@RequestBody Review review) {
		Review existingReview = reviews.stream().filter(x -> x.getId() == review.getId()).findFirst().orElse(null);
		existingReview.copy(review);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void deleteReview(@PathVariable int id) {
		Review reviewToRemove = reviews.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		reviews.remove(reviewToRemove);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Review retrieveReview(@PathVariable int id) {
		return reviews.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Review> retrieveReviews() {
		return reviews;
	}

}
