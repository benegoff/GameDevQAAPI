package goff.ben.restapi.models;

public class Bug {
    private int id;
    private int gameId;
    private string description;
    private int priorityId;
    private string authorUsername;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public string getDescription() {
        return description;
    }

    public void setDescription(string description) {
        this.description = description;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public string getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(string authorUsername) {
        this.authorUsername = authorUsername;
    }
}
