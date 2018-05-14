package gamedevqa.models;

public class Bug {
    private int id;
    private Game game;
    private String description;
    private Priority priority;
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
