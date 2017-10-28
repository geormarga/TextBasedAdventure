package textbasedadventure.webapp.models;

public class UserModel {
    private String username;
    private String email;
    private String password;

    public UserModel() {
    }

    public UserModel(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean usernameExists(String username) {
        return this.username.equals(username);
    }

    public boolean login(String username,String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
