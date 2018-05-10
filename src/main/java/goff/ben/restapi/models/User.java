package goff.ben.restapi.models;

public class User {
    private string username;
    private string passwordHash;
    private int roleId;
    private string profileImagePath;
    private string biography;

    public string getUsername() {
        return username;
    }

    public void setUsername(string username) {
        this.username = username;
    }

    public string getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(string passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public string getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(string profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public string getBiography() {
        return biography;
    }

    public void setBiography(string biography) {
        this.biography = biography;
    }
}
