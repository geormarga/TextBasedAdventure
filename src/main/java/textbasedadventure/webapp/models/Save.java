package textbasedadventure.webapp.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Save {
    @Id
    private String id;
    private String username;
    private String save_game;
    @CreatedDate
    private Date created_date;

    public Save() {
    }

    public Save(String username, String save_game) {
        this.username = username;
        this.save_game = save_game;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSave_game() {
        return save_game;
    }

    public void setSave_game(String save_game) {
        this.save_game = save_game;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}
