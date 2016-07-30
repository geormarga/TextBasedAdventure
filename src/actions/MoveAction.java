/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Moveable;
import items.Item;
import messages.IMessage;
import messages.action.MoveFailureMessage;
import rooms.Room;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class MoveAction implements Action<Moveable> {

    @Override
    public boolean execute(State state, Moveable moveable) {

        if (moveable instanceof Moveable) {
            moveable.move(state);
            return true;
        }
        IMessage message = new MoveFailureMessage();
        message.display();
        return true;
    }

    /*  Returns true if the string represents any room nearby to this room. Else returns false.
     */
    @Override
    public boolean existsInContext(State state, Moveable moveable) {
        Room room = (Room) moveable;
        return state.getCurrentRoom().getNearbyRooms().contains(room.getName());
    }
}
