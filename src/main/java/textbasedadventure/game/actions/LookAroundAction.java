/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.actions;

import textbasedadventure.game.features.Lookable;
import textbasedadventure.game.rooms.Room;
import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public class LookAroundAction implements Action<Lookable> {

    @Override
    public String execute(State state, Lookable lookable) {
        return lookable.look();
    }

    @Override
    public boolean isEligibleForAction(State state, Lookable lookable) {
        Room room = (Room) lookable;
        return state.getCurrentRoom().getName().equals(room.getName());
    }

}
