/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.actions;

import textbasedadventure.game.features.Pullable;
import textbasedadventure.game.items.Item;
import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public class PullAction implements Action<Pullable> {

    @Override
    public String execute(State state, Pullable pullable) {
        return pullable.pull();
    }

    @Override
    public boolean isEligibleForAction(State state, Pullable pullable) {
        Item item = (Item) pullable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName());
    }
}
