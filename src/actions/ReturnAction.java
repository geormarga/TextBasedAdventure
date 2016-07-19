/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Moveable;
import rooms.Room;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class ReturnAction implements Action<Moveable>{
    
    @Override
    public boolean execute(State state, Moveable moveable) {
        Room lastRoom;
        if (!state.getRoute().empty()) {
            lastRoom = (Room) state.getRoute().pop();
            state.setCurrentRoom(lastRoom);
            System.out.println(state.getCurrentRoom().getDescription());
        }
        return true;
    }
    
}
