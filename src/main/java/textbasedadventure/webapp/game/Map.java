package textbasedadventure.webapp.game;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Map {

    @Autowired
    private Persistence persistence;

    /**
     * Method that maps the user given attributes to game contextual objects depending on the current room
     *
     * @param currentRoom The room currently at
     * @param attributes  The command attributes that have been parsed
     */
    List<String> getRoomInDirection(String currentRoom, List<String> attributes) {
        JSONArray jsonArray = (JSONArray) persistence
                .getRoomsArray()
                .stream()
                .filter(cmd -> ((JSONObject) cmd).get("name").equals(currentRoom))
                .map(cmd -> ((JSONObject) cmd).get("adjacentRooms"))
                .findFirst().get();

        return (List<String>) jsonArray
                .stream()
                .filter(cmd -> attributes.contains(((JSONObject) cmd).get("text")))
                .map(room -> ((JSONObject) room).get("name"))
                .collect(Collectors.toList());
    }


    /**
     * Method that gets the adjacent rooms as defined in the xml file
     *
     * @param roomName The name of the room
     * @return The adjacent rooms for the specified roomName
     */
    public List<String> getNearbyRooms(String roomName) {
        JSONArray jsonArray = (JSONArray) persistence.getRoomsArray()
                .stream()
                .filter(room -> ((JSONObject) room).get("name").equals(roomName))
                .map(room -> ((JSONObject) room).get("adjacentRooms"))
                .findFirst().get();

        return (List<String>) jsonArray
                .stream()
                .map(room -> ((JSONObject) room).get("name"))
                .collect(Collectors.toList());
    }

    /**
     * Method that gets a room's items
     *
     * @param roomName The name of the room
     * @return The contained items for the specified roomName
     */
    public List<String> getRoomItems(String roomName) {
        List<JSONArray> returnList = (List<JSONArray>) persistence.getItemsArray()
                .stream()
                .filter(cmd -> ((JSONObject) cmd).get("name").equals(roomName))
                .map(cmd -> ((JSONObject) cmd).getOrDefault("items", null))
                .collect(Collectors.toList());

        return returnList.isEmpty() ? Collections.emptyList() : (List<String>) returnList.get(0);

    }

    /**
     * Method that checks if the room given is adjacent to the current room
     *
     * @param currentRoom The room currently at
     * @param adjacentRoom  The possibly adjacent room
     */
    public boolean isAdjacent(String currentRoom, String adjacentRoom) {
        JSONArray jsonArray = (JSONArray) persistence
                .getRoomsArray()
                .stream()
                .filter(cmd -> ((JSONObject) cmd).get("name").equals(currentRoom))
                .map(cmd -> ((JSONObject) cmd).get("adjacentRooms"))
                .findFirst().get();
        return jsonArray.stream().anyMatch(cmd -> ((JSONObject) cmd).get("name").equals(adjacentRoom));
    }


}
