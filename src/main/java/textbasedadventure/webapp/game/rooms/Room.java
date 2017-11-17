/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.features.Lookable;
import textbasedadventure.webapp.game.features.Moveable;
import textbasedadventure.webapp.game.State;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aenaos
 */
@Component
public abstract class Room implements Lookable, Serializable, Moveable {

    private List<String> nearbyRooms;
    private List<String> roomItems;
    protected String name;
    protected String description;
    protected String hint;
    @Autowired
    protected Map map;


    public void registerItem(String itemName) {
        roomItems.add(itemName);
    }

    public void unregisterItem(String itemName) {
        roomItems.remove(itemName);
    }

    void registerRoom(String roomName) {
        nearbyRooms.add(roomName);
    }

    public void unregisterRoom(String roomName) {
        nearbyRooms.remove(roomName);
    }

    public void setRoomItems(List<String> list) {
        this.roomItems = list;
    }

    public List<String> getRoomItems() {
        return this.roomItems;
    }

    public void setNearbyRooms(List<String> list) {
        this.nearbyRooms = list;
    }

    public List<String> getNearbyRooms() {
        return this.nearbyRooms;
    }

    boolean existsInRoom(String itemName) {
        return roomItems.contains(itemName);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String getMovementMessage() {
        return this.getDescription();
    }

    @Override
    public String look() {
        return hint;
    }

    @Override
    public String move(State state) {
        state.setPreviousRoom(state.getCurrentRoom());
        state.setCurrentRoom(this);
        return this.getMovementMessage();
    }
}
