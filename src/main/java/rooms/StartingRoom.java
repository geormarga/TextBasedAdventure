/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class StartingRoom extends Room {

    public StartingRoom() {

        name = "starting room";
        description = "Welcome, this is the starting room!\n"
                + "The goal of the game is to collect all artifacts\n"
                + "and find the Escape Room to escape.\n"
                + "By typing exit game, you can exit anytime. Type start game to begin...";
        hint = "This is the starting room. What did you expect to see?";
      
    }
    
    @Override
    public void move(State state) {
        state.setPreviousRoom(this);
        state.setCurrentRoom(this);
        this.getMovementMessage();
    }
}
