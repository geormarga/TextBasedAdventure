/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Turnable;
import items.Item;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class TurnAction implements Action<Turnable> {

    @Override
    public boolean execute(State state, Turnable turnable) {
        turnable.turn(state);
        return true;
    }
    
    
    /*  Returns true if the string represents an item in the current room. Else returns false.
     */
    @Override
    public boolean existsInContext(State state, Turnable turnable) {
        Item item = (Item) turnable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName());
    }
}
