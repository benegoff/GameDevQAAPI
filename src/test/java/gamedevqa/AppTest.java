package gamedevqa;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

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
    public void test_WhenAddingUser_ThenCanGetAddedUser() {
		User user1 = new User();
		user1.setId(1);
		user1.setUsername("User1");
		user1.setPasswordHash("+3$+");
		user1.setProfileImagePath("testPath.png");
		user1.setBiography("Test Biography");
		
		given().
	    when().
	    	post("http://localhost:8080/users", user1).
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
	    when().
	    	post("http://localhost:8080/games", game1).
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
	    when().
	    	post("http://localhost:8080/bugs", bug1).
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
	    when().
	    	post("http://localhost:8080/reviews", review1).
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
				body("stars", is(4.2));
    }
	
	@Test
    public void test_WhenAddingSuggestion_ThenCanGetAddedSuggestion() {
		Suggestion suggestion1 = new Suggestion();
		suggestion1.setId(1);
		suggestion1.setDescription("Add funky music.");
		
		given().
	    when().
	    	post("http://localhost:8080/suggestions", suggestion1).
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
}
