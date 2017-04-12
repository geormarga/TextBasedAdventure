/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.FeatureFactory;
import textbasedadventure.ReadXMLFile;
import textbasedadventure.State;

/**
 * @author Aenaos
 */
public class StartingRoom extends Room {

    public StartingRoom(FeatureFactory featureFactory, ReadXMLFile readXMLFile) {
        name = "starting room";
        description = "Welcome, this is the starting room!\n"
                + "The goal of the game is to collect all artifacts\n"
                + "and find the Escape Room to escape.\n"
                + "By typing exit game, you can exit anytime. Type start game to begin...";
        hint = "This is the starting room. What did you expect to see?";
        featureFactory.registerFeature(this.name, this);
        this.setNearbyRooms(readXMLFile.getNearbyRooms(this.name));
        this.setRoomItems(readXMLFile.getRoomItems(this.name));
    }

    @Override
    public void move(State state) {
        state.setPreviousRoom(this);
        state.setCurrentRoom(this);
        this.getMovementMessage();
    }
}
