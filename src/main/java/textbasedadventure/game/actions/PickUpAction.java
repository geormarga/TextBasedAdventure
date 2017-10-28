/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.actions;

import textbasedadventure.game.features.Pickable;
import textbasedadventure.game.items.Item;
import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public class PickUpAction implements Action<Pickable> {

    @Override
    public String execute(State state, Pickable pickable) {
        return pickable.pickup(state.getInventory(), state.getCurrentRoom());
    }


    @Override
    public boolean isEligibleForAction(State state, Pickable pickable) {
        Item item = (Item) pickable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName());
    }
}
