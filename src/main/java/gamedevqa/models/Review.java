package gamedevqa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="REVIEWS")
public class Review {
	
	@Id
	@Column(name="review_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	@JoinColumn(name="game_id")
	@ManyToOne
    private Game game;
	
    private double stars;
    
    private String description;
    
    @JoinColumn(name="user_id")
    @ManyToOne
    private User author;
    
    public void copy(Review source) {
    	setId(source.getId());
    	setStars(source.getStars());
    	setDescription(source.getDescription());
    }

    public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
