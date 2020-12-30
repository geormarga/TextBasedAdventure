/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import java.util.List;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.Usable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.State;

/**
 * @author Aenaos
 */
@Component("use")
public class UseAction implements Action {

    @Override
    public String execute(State state, List<Feature> usables) {
        Usable usable = (Usable) usables.get(0);
        return usable.use(state.getInventory(), state.getCurrentRoom());
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> usables) {
        Usable usable = (Usable) usables.get(0);
        Item item = (Item) usable;
        return state.getInventory().isInInventory(item.getName());
    }
}
