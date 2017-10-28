/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.actions;

import textbasedadventure.game.features.Moveable;
import textbasedadventure.game.rooms.Room;
import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public class MoveAction implements Action<Moveable> {

    @Override
    public String execute(State state, Moveable moveable) {
        return moveable.move(state);
    }

    @Override
    public boolean isEligibleForAction(State state, Moveable moveable) {
        Room room = (Room) moveable;
        return state.getCurrentRoom().getNearbyRooms().contains(room.getName());
    }
}
