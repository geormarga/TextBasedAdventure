/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Usable;
import items.Item;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class UseAction implements Action<Usable> {

    @Override
    public boolean execute(State state, Usable usable) {
        usable.use(state.getInventory(), state.getCurrentRoom());
        return true;
    }
    
    /*  Returns true if the string represents an item in the current room. Else returns false.
     */
    @Override
    public boolean existsInContext(State state, Usable usable) {
        Item item = (Item) usable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName())||state.getInventory().isInInventory(item.getName());
    }
}
