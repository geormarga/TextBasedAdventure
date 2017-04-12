/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.Lookable;
import features.Moveable;
import textbasedadventure.State;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aenaos
 */
public abstract class Room implements Lookable, Serializable, Moveable {

    private List<String> nearbyRooms;
    private List<String> roomItems;
    protected String name;
    protected String description;
    protected String hint;

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

    public void getMovementMessage() {
        System.out.println(this.getDescription());
    }

    @Override
    public void look() {
        System.out.println(hint);
    }

    @Override
    public void move(State state) {
        state.setPreviousRoom(state.getCurrentRoom());
        state.setCurrentRoom(this);
        this.getMovementMessage();
    }
}
