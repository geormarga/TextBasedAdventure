/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import java.util.List;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.State;

/**
 * @author Aenaos
 */
@Component("pick up")
public class PickUpAction implements Action {

    @Override
    public String execute(State state, List<Feature> pickables) {
        Pickable pickable = (Pickable) pickables.get(0);
        return pickable.pickup(state.getInventory(), state.getCurrentRoom());
    }


    @Override
    public boolean isEligibleForAction(State state, List<Feature> pickables) {
        Pickable pickable = (Pickable) pickables.get(0);
        Item item = (Item) pickable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName());
    }
}
