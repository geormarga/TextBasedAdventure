/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import java.util.List;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.Turnable;
import textbasedadventure.webapp.game.items.Item;

/**
 * @author Aenaos
 */
@Component("turn")
public class TurnAction implements Action {

    @Override
    public String execute(State state, List<Feature> turnables) {
        Turnable turnable = (Turnable) turnables.get(0);
        return turnable.turn(state);
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> turnables) {
        Turnable turnable = (Turnable) turnables.get(0);
        Item item = (Item) turnable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName());
    }
}
