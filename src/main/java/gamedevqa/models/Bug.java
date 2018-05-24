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
@Table(name="BUGS")
public class Bug {
	
	@Id
	@Column(name="bug_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	@JoinColumn(name="game_id")
	@ManyToOne
    private Game game;
    
    private String description;
    
	@JoinColumn(name="priority_id")
	@ManyToOne
    private Priority priority;
    
	@JoinColumn(name="user_id")
	@ManyToOne
    private User author;

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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    
    public void copy(Bug source) {
    	setId(source.getId());
    	setDescription(source.getDescription());
    	setPriority(source.getPriority());
    }
}
