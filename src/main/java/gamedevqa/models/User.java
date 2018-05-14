package gamedevqa.models;

import java.util.List;

public class User {
	
	private int id;
	private String username;
    private String passwordHash;
    private Role role;
    private String profileImagePath;
    private String biography;
    
    private List<Game> games;
    private List<Review> reviews;
    private List<Suggestion> suggestions;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
