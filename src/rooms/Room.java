/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.Containable;
import features.Lookable;
import features.Moveable;
import items.Item;
import java.io.Serializable;
import java.util.HashMap;
import textbasedadventure.HashMapOfElements;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public abstract class Room implements Lookable, Serializable, Moveable {

    protected HashMapOfElements<Room> nearbyRooms = new HashMapOfElements<>();
    protected HashMapOfElements<Item> roomItems = new HashMapOfElements<>();
    protected String description;
    protected String hint;
    protected Containable containerType;

    public HashMapOfElements<Room> getNearbyRooms() {
        return nearbyRooms;
    }

    public void setNearbyRooms(HashMap<String, Room> par) {
        nearbyRooms.setElements(par);
    }

    public HashMapOfElements<Item> getRoomItems() {
        return roomItems;
    }

    public void setRoomItems(HashMap<String, Item> par) {
        roomItems.setElements(par);
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

    public Containable getContainerType() {
        return containerType;
    }

    public void setContainerType(Containable containerType) {
        this.containerType = containerType;
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
        state.getRoute().push(this);
        state.setCurrentRoom(this);
        this.getMovementMessage();
    }
}
