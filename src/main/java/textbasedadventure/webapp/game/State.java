/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.FeatureFactory;
import textbasedadventure.webapp.game.rooms.Room;

import javax.annotation.PostConstruct;

@Component
public class State {

    @Autowired
    @Qualifier("starting room")
    private Room currentRoom;
    @Autowired
    @Qualifier("starting room")
    private Room previousRoom;
    @Autowired
    private Inventory inventory;
    @Autowired
    private FeatureFactory featureFactory;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public FeatureFactory getFeatureFactory() {
        return featureFactory;
    }

    public State() {
    }

    @PostConstruct
    private void init(){
        System.out.println(this.currentRoom.getDescription());
    }
}
