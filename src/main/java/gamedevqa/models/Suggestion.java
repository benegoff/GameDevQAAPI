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
@Table(name="SUGGESTIONS")
public class Suggestion {
	
	@Id
	@Column(name="suggestion_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	@JoinColumn(name="game_id")
	@ManyToOne
    private Game game;
	
    private String description;
    
    @JoinColumn(name="user_id")
    @ManyToOne
    private User suggestionAuthor;
    
    public void copy(Suggestion source) {
    	setId(source.getId());
    	setDescription(source.getDescription());
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getSuggestionAuthor() {
        return suggestionAuthor;
    }

    public void setSuggestionAuthor(User suggestionAuthor) {
        this.suggestionAuthor = suggestionAuthor;
    }
}
