package textbasedadventure.webapp.game;

import javax.annotation.PostConstruct;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.parsing.JSONParser;

@Component
public class Persistence {
    private JSONArray roomsArray, itemsArray;

    Persistence() {
    }

    @PostConstruct
    public void init() {
        roomsArray = JSONParser.toJsonArray("src/main/resources/Rooms.json", "rooms");
        itemsArray = JSONParser.toJsonArray("src/main/resources/Items.json", "rooms");
    }

    public JSONArray getRoomsArray() {
        return roomsArray;
    }

    public void setRoomsArray(JSONArray roomsArray) {
        this.roomsArray = roomsArray;
    }

    public JSONArray getItemsArray() {
        return itemsArray;
    }

    public void setItemsArray(JSONArray itemsArray) {
        this.itemsArray = itemsArray;
    }
}
