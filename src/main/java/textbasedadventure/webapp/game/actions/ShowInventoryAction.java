/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import java.util.List;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.Inventory;
import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.Showable;

/**
 * @author Aenaos
 */
@Component("show")
public class ShowInventoryAction implements Action {

    @Override
    public String execute(State state, List<Feature> showables) {
        Showable showable = (Showable) showables.get(0);
        return showable.show();
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> showables) {
        Showable showable = (Showable) showables.get(0);
        Inventory inventory = (Inventory) showable;
        return state.getInventory().getName().equals(inventory.getName());
    }
}
