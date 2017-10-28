/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.actions;

import textbasedadventure.game.features.Showable;
import textbasedadventure.game.Inventory;
import textbasedadventure.game.State;

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
