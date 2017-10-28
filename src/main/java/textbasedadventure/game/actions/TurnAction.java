/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.actions;

import textbasedadventure.game.features.Turnable;
import textbasedadventure.game.items.Item;
import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public class TurnAction implements Action<Turnable> {

    @Override
    public String execute(State state, Turnable turnable) {
        return turnable.turn(state);
    }

    @Override
    public boolean isEligibleForAction(State state, Turnable turnable) {
        Item item = (Item) turnable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName());
    }
}
