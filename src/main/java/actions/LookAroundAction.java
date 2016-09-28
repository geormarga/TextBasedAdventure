/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Lookable;
import rooms.Room;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class LookAroundAction implements Action<Lookable> {

    @Override
    public boolean execute(State state, Lookable lookable) {
        lookable.look();
        return true;
    }

    /*  Returns true if the string represents the current room. Else returns false.
     */
    @Override
    public boolean existsInContext(State state, Lookable lookable) {
        Room room = (Room) lookable;
        return state.getCurrentRoom().getName().equals(room.getName());
    }

}
