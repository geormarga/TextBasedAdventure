/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.rooms;

import textbasedadventure.game.features.FeatureFactory;
import textbasedadventure.game.Map;
import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public class StartingRoom extends Room {

    public StartingRoom(FeatureFactory featureFactory, Map map) {
        name = "starting room";
        description = "Welcome, this is the starting room!\n"
                + "The goal of the game is to collect all artifacts\n"
                + "and find the Escape Room to escape.\n"
                + "By typing exit game, you can exit anytime. Type start game to begin...";
        hint = "This is the starting room. What did you expect to see?";
        featureFactory.registerFeature(this.name, this);
        this.setNearbyRooms(map.getNearbyRooms(this.name));
        this.setRoomItems(map.getRoomItems(this.name));
    }

    @Override
    public String move(State state) {
        state.setPreviousRoom(this);
        state.setCurrentRoom(this);
        return this.getMovementMessage();
    }
}
