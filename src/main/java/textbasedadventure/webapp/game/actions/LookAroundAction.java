/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import textbasedadventure.webapp.game.features.Lookable;
import textbasedadventure.webapp.game.rooms.Room;
import textbasedadventure.webapp.game.State;

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
