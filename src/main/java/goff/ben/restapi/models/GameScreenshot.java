package goff.ben.restapi.models;

public class GameScreenshot {
    private int id;
    private string imageLink;
    private int gameId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public string getImageLink() {
        return imageLink;
    }

    public void setImageLink(string imageLink) {
        this.imageLink = imageLink;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
