package gamedevqa.models;

public class Review {
    private int id;
    private Game game;
    private double stars;
    private String description;

    public void copy(Review source) {
    	setId(source.getId());
    	setStars(source.getStars());
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
