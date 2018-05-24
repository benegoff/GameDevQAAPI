package gamedevqa.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique=true)
	private String username;
    private String passwordHash;
    private String profileImagePath;
    private String biography;
    
    @ElementCollection
    private List<String> roles;
    
    @OneToMany
    private List<Game> games;
    
    @OneToMany
    private List<Review> reviews;
    
    @OneToMany
    private List<Suggestion> suggestions;
    
    @OneToMany
    private List<Bug> authoredBugs;
    
    public void copy(User source) {
    	setId(source.getId());
    	setPasswordHash(source.getPasswordHash());
    	setProfileImagePath(source.getProfileImagePath());
    	setBiography(source.getBiography());
    }
    
    public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Suggestion> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public List<Bug> getAuthoredBugs() {
		return authoredBugs;
	}

	public void setAuthoredBugs(List<Bug> authoredBugs) {
		this.authoredBugs = authoredBugs;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
