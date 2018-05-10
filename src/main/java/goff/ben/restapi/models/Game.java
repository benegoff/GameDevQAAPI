package goff.ben.restapi.models;

public class Game {
    private int id;
    private string creatorUsername;
    private string title;
    private string description;
    private int genreId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public string getCreatorUsername() {
        return creatorUsername;
    }

    public void setCreatorUsername(string creatorUsername) {
        this.creatorUsername = creatorUsername;
    }

    public string getTitle() {
        return title;
    }

    public void setTitle(string title) {
        this.title = title;
    }

    public string getDescription() {
        return description;
    }

    public void setDescription(string description) {
        this.description = description;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
