/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import textbasedadventure.webapp.game.features.Showable;
import textbasedadventure.webapp.game.Inventory;
import textbasedadventure.webapp.game.State;

/**
 * @author Aenaos
 */
public class ShowInventoryAction implements Action<Showable> {

    @Override
    public String execute(State state, Showable showable) {
        return showable.show();
    }

    @Override
    public boolean isEligibleForAction(State state, Showable showable) {
        Inventory inventory = (Inventory) showable;
        return state.getInventory().getName().equals(inventory.getName());
    }
}
