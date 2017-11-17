/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Turnable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.State;

/**
 * @author Aenaos
 */
@Component("turn")
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
