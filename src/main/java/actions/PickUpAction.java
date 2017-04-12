/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Pickable;
import items.Item;
import messages.IMessage;
import messages.action.PickUpFailureMessage;
import textbasedadventure.State;

/**
 * @author Aenaos
 */
public class PickUpAction implements Action<Pickable> {

    @Override
    public boolean execute(State state, Pickable pickable) {

        if (pickable != null) {
            pickable.pickup(state.getInventory(), state.getCurrentRoom());
            return true;
        }
        IMessage message = new PickUpFailureMessage();
        message.display();
        return true;
    }


    @Override
    /*  Returns true if the string represents an item in the current room. Else returns false.
     */
    public boolean existsInContext(State state, Pickable pickable) {
        Item item = (Item) pickable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName());
    }
}
