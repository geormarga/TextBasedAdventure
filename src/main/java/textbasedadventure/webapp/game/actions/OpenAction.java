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
import textbasedadventure.webapp.game.features.Openable;
import textbasedadventure.webapp.game.items.Item;

/**
 * @author Aenaos
 */
@Component("open")
public class OpenAction implements Action {

    @Override
    public String execute(State state, List<Feature> openables) {
        Openable openable = (Openable) openables.get(0);
        return openable.open(state.getInventory());
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> openables) {
        Openable openable = (Openable) openables.get(0);
        Item item = (Item) openable;
        return state.getCurrentRoom().getRoomContainer().isInContainer(item.getName());
    }
}
