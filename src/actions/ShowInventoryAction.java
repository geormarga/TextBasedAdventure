/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Showable;
import textbasedadventure.Inventory;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class ShowInventoryAction implements Action<Showable> {

    @Override
    public boolean execute(State state, Showable showable) {
        showable.show();
        return true;
    }

    /*  Returns true if the string represents the user's inventory. Else returns false.
     */
    @Override
    public boolean existsInContext(State state, Showable showable) {
        Inventory inventory = (Inventory) showable;
        return state.getInventory().getName().equals(inventory.getName());
    }

}
