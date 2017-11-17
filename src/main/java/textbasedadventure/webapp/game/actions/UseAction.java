/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import textbasedadventure.webapp.game.features.Usable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.State;

/**
 * @author Aenaos
 */
public class UseAction implements Action<Usable> {

    @Override
    public String execute(State state, Usable usable) {
        return usable.use(state.getInventory(), state.getCurrentRoom());
    }

    @Override
    public boolean isEligibleForAction(State state, Usable usable) {
        Item item = (Item) usable;
        return state.getInventory().isInInventory(item.getName());
    }
}
