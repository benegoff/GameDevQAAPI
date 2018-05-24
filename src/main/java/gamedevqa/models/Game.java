package gamedevqa.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GAMES")
public class Game {
	
	@Id
	@Column(name="game_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	@JoinColumn(name="user_id")
	@ManyToOne
    private User creator;
    
    private String title;
    
    private String description;
    
    @JoinColumn(name="genre_id")
    @ManyToOne
    private Genre genre;
    
    @OneToMany
    private List<Bug> bugs;
    
    @OneToMany
    private List<Suggestion> suggestions;
    
    @OneToMany
    private List<Review> reviews;
    
    @ElementCollection
    private List<String> screenshotLinks;
    
    public void copy(Game source) {
    	setId(source.getId());
    	setTitle(source.getTitle());
    	setDescription(source.getDescription());
    	setGenre(source.getGenre());
    }

    public List<String> getScreenshotLinks() {
		return screenshotLinks;
	}

	public void setScreenshotLinks(List<String> screenshotLinks) {
		this.screenshotLinks = screenshotLinks;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

	public List<Suggestion> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
