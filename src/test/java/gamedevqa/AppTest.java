package gamedevqa;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

import org.json.JSONException;
import org.junit.Test;

import gamedevqa.models.Bug;
import gamedevqa.models.Game;
import gamedevqa.models.Review;
import gamedevqa.models.Suggestion;
import gamedevqa.models.User;
import io.restassured.http.ContentType;

public class AppTest {
	
	@Test
    public void test_WhenGettingGenres_ThenAllAreReturned() {
		
		given().
	    when().
	        get("http://localhost:8080/genres").
	    then().
	        assertThat().
	        statusCode(200).
		    and().
		        contentType(ContentType.JSON).
		    and().
		    	body("name", hasItems("RPG", "FPS"));
    }
	
	@Test
    public void test_WhenGettingSpecificGenre_ThenOnlyThatOneReturned() {
		
		given().
	    when().
	        get("http://localhost:8080/genres/1").
	    then().
	        assertThat().
	        statusCode(200).
		    and().
		        contentType(ContentType.JSON).
		    and().
		    	body("name", is("RPG"));
    }
	
	@Test
    public void test_WhenGettingPriorities_ThenAllAreReturned() {
		
		given().
	    when().
	        get("http://localhost:8080/priorities").
	    then().
	        assertThat().
	        statusCode(200).
		    and().
		        contentType(ContentType.JSON).
		    and().
		    	body("description", hasItems("Low", "Critical"));
    }
	
	@Test
    public void test_WhenGettingSpecificPriority_ThenOnlyThatOneReturned() {
		
		given().
	    when().
	        get("http://localhost:8080/priorities/1").
	    then().
	        assertThat().
	        statusCode(200).
		    and().
		        contentType(ContentType.JSON).
		    and().
		    	body("description", is("Low"));
    }
	
	@Test
    public void test_WhenGettingRoles_ThenAllAreReturned() {
		
		given().
	    when().
	        get("http://localhost:8080/roles").
	    then().
	        assertThat().
	        statusCode(200).
		    and().
		        contentType(ContentType.JSON).
		    and().
		    	body("name", hasItems("User", "Admin"));
    }
	
	@Test
    public void test_WhenGettingSpecificRole_ThenOnlyThatOneReturned() {
		
		given().
	    when().
	        get("http://localhost:8080/roles/1").
	    then().
	        assertThat().
	        statusCode(200).
		    and().
		        contentType(ContentType.JSON).
		    and().
		    	body("name", is("User"));
    }
	
	@Test
    public void test_WhenAddingUser_ThenCanGetAddedUser() throws JSONException {
		User user1 = new User();
		user1.setId(1);
		user1.setUsername("User1");
		user1.setPasswordHash("+3$+");
		user1.setProfileImagePath("testPath.png");
		user1.setBiography("Test Biography");
		
		given().
			header("Content-Type", "application/json").
			body(user1).
	    when().
	    	post("http://localhost:8080/users").
	    then().
	        assertThat().
	        statusCode(200);
		
		given().
	    when().
	    	get("http://localhost:8080/users/1").
	    then().
	        assertThat().
	        statusCode(200).
	        and().
	        	contentType(ContentType.JSON).
	        and().
	    		body("username", is("User1")).
	    	and().
	    		body("passwordHash", is("+3$+")).
	    	and().
	    		body("profileImagePath", is("testPath.png")).
	    	and().
	    		body("biography", is("Test Biography"));
    }
	
	@Test
    public void test_WhenAddingGame_ThenCanGetAddedGame() {
		Game game1 = new Game();
		game1.setId(1);
		game1.setTitle("My Game");
		game1.setDescription("This is my game.");
		
		given().
			header("Content-Type", "application/json").
			body(game1).
	    when().
	    	post("http://localhost:8080/games").
	    then().
	        assertThat().
	        statusCode(200);
		
		given().
	    when().
	    	get("http://localhost:8080/games/1").
	    then().
	        assertThat().
	        statusCode(200).
	        and().
	        	contentType(ContentType.JSON).
	        and().
	    		body("title", is("My Game")).
	    	and().
	    		body("description", is("This is my game."));
    }
	
	@Test
    public void test_WhenAddingBug_ThenCanGetAddedBug() {
		Bug bug1 = new Bug();
		bug1.setId(1);
		bug1.setDescription("When you press A the game crashes.");
		
		given().
			header("Content-Type", "application/json").
			body(bug1).
	    when().
	    	post("http://localhost:8080/bugs").
	    then().
	        assertThat().
	        statusCode(200);
		
		given().
	    when().
	    	get("http://localhost:8080/bugs/1").
	    then().
	        assertThat().
	        statusCode(200).
	        and().
	        	contentType(ContentType.JSON).
	        and().
	    		body("description", is("When you press A the game crashes."));
    }
	
	@Test
    public void test_WhenAddingReview_ThenCanGetAddedReview() {
		Review review1 = new Review();
		review1.setId(1);
		review1.setStars(4.2);
		review1.setDescription("This is fun.");
		
		given().
			header("Content-Type", "application/json").
			body(review1).
	    when().
	    	post("http://localhost:8080/reviews").
	    then().
	        assertThat().
	        statusCode(200);
		
		given().
	    when().
	    	get("http://localhost:8080/reviews/1").
	    then().
	        assertThat().
	        statusCode(200).
	        and().
	        	contentType(ContentType.JSON).
	        and().
	    		body("description", is("This is fun.")).
			and().
				body("stars", is(4.2f));
    }
	
	@Test
    public void test_WhenAddingSuggestion_ThenCanGetAddedSuggestion() {
		Suggestion suggestion1 = new Suggestion();
		suggestion1.setId(1);
		suggestion1.setDescription("Add funky music.");
		
		given().
			header("Content-Type", "application/json").
			body(suggestion1).
	    when().
	    	post("http://localhost:8080/suggestions").
	    then().
	        assertThat().
	        statusCode(200);
		
		given().
	    when().
	    	get("http://localhost:8080/suggestions/1").
	    then().
	        assertThat().
	        statusCode(200).
	        and().
	        	contentType(ContentType.JSON).
	        and().
	    		body("description", is("Add funky music."));
    }
	
	@Test
    public void test_WhenUpdatingThenDeletingUser_ThenFieldIsUpdatedThenRemoved() throws JSONException {
		User user1 = new User();
		user1.setId(2);
		user1.setUsername("User2");
		user1.setPasswordHash("+3$+2");
		user1.setProfileImagePath("testPath2.png");
		user1.setBiography("Test Biography 2");
		
		given().
			header("Content-Type", "application/json").
			body(user1).
	    when().
	    	post("http://localhost:8080/users").
	    then().
	        assertThat().
	        statusCode(200);
		
		user1.setBiography("Updated Biography");
		
		given().
			header("Content-Type", "application/json").
			body(user1).
	    when().
	    	put("http://localhost:8080/users").
	    then().
	        assertThat().
	        statusCode(200);
		
		given().
	    when().
	    	get("http://localhost:8080/users/2").
	    then().
	        assertThat().
	        statusCode(200).
	        and().
	        	contentType(ContentType.JSON).
	        and().
	        	body("biography", is("Updated Biography"));
		
		given().
	    when().
	    	delete("http://localhost:8080/users/2").
	    then().
	        assertThat().
	        statusCode(200);
    }
	
	@Test
    public void test_WhenUpdatingThenDeletingBug_ThenFieldIsUpdatedThenRemoved() throws JSONException {
		Bug bug1 = new Bug();
		bug1.setId(2);
		bug1.setDescription("Test Description");
		
		given().
			header("Content-Type", "application/json").
			body(bug1).
	    when().
	    	post("http://localhost:8080/bugs").
	    then().
	        assertThat().
	        statusCode(200);
		
		bug1.setDescription("Updated Description");
		
		given().
			header("Content-Type", "application/json").
			body(bug1).
	    when().
	    	put("http://localhost:8080/bugs").
	    then().
	        assertThat().
	        statusCode(200);
		
		given().
	    when().
	    	get("http://localhost:8080/bugs/2").
	    then().
	        assertThat().
	        statusCode(200).
	        and().
	        	contentType(ContentType.JSON).
	        and().
	        	body("description", is("Updated Description"));
		
		given().
	    when().
	    	delete("http://localhost:8080/bugs/2").
	    then().
	        assertThat().
	        statusCode(200);
    }
	
	@Test
    public void test_WhenUpdatingThenDeletingReview_ThenFieldIsUpdatedThenRemoved() throws JSONException {
		Review review1 = new Review();
		review1.setId(2);
		review1.setStars(4.2);
		review1.setDescription("Test Description");
		
		given().
			header("Content-Type", "application/json").
			body(review1).
	    when().
	    	post("http://localhost:8080/reviews").
	    then().
	        assertThat().
	        statusCode(200);
		
		review1.setStars(2.5);
		
		given().
			header("Content-Type", "application/json").
			body(review1).
	    when().
	    	put("http://localhost:8080/reviews").
	    then().
	        assertThat().
	        statusCode(200);
		
		given().
	    when().
	    	get("http://localhost:8080/reviews/2").
	    then().
	        assertThat().
	        statusCode(200).
	        and().
	        	contentType(ContentType.JSON).
	        and().
	        	body("stars", is(2.5f));
		
		given().
	    when().
	    	delete("http://localhost:8080/reviews/2").
	    then().
	        assertThat().
	        statusCode(200);
    }
	
	@Test
    public void test_WhenUpdatingThenDeletingSuggestion_ThenFieldIsUpdatedThenRemoved() throws JSONException {
		Suggestion suggestion1 = new Suggestion();
		suggestion1.setId(2);
		suggestion1.setDescription("Test Description");
		
		given().
			header("Content-Type", "application/json").
			body(suggestion1).
	    when().
	    	post("http://localhost:8080/suggestions").
	    then().
	        assertThat().
	        statusCode(200);
		
		suggestion1.setDescription("Updated Description");
		
		given().
			header("Content-Type", "application/json").
			body(suggestion1).
	    when().
	    	put("http://localhost:8080/suggestions").
	    then().
	        assertThat().
	        statusCode(200);
		
		given().
	    when().
	    	get("http://localhost:8080/suggestions/2").
	    then().
	        assertThat().
	        statusCode(200).
	        and().
	        	contentType(ContentType.JSON).
	        and().
	        	body("description", is("Updated Description"));
		
		given().
	    when().
	    	delete("http://localhost:8080/suggestions/2").
	    then().
	        assertThat().
	        statusCode(200);
    }
	
	@Test
    public void test_WhenUpdatingThenDeletingGame_ThenFieldIsUpdatedThenRemoved(){
		Game game1 = new Game();
		game1.setId(2);
		game1.setTitle("My Game");
		game1.setDescription("This is my game.");
		
		given().
			header("Content-Type", "application/json").
			body(game1).
	    when().
	    	post("http://localhost:8080/games").
	    then().
	        assertThat().
	        statusCode(200);
		
		game1.setDescription("This is my updated game.");
		
		given().
			header("Content-Type", "application/json").
			body(game1).
	    when().
	    	put("http://localhost:8080/games").
	    then().
	        assertThat().
	        statusCode(200);
		
		given().
	    when().
	    	get("http://localhost:8080/games/2").
	    then().
	        assertThat().
	        statusCode(200).
	        and().
	        	contentType(ContentType.JSON).
	        and().
	        	body("description", is("This is my updated game."));
		
		given().
	    when().
	    	delete("http://localhost:8080/games/2").
	    then().
	        assertThat().
	        statusCode(200);
    }
}
