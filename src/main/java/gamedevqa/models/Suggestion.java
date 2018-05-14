package gamedevqa.models;

public class Suggestion {
    private int id;
    private Game game;
    private String description;
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
