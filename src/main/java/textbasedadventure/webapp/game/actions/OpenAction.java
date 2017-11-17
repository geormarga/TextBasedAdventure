/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import textbasedadventure.webapp.game.features.Openable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.State;

/**
 * @author Aenaos
 */
public class OpenAction implements Action<Openable> {

    @Override
    public String execute(State state, Openable openable) {
        return openable.open(state.getInventory());
    }

    @Override
    public boolean isEligibleForAction(State state, Openable openable) {
        Item item = (Item) openable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName());
    }
}
