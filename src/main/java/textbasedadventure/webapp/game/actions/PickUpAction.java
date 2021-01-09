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
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.items.Item;

/**
 * @author Aenaos
 */
@Component("pick up")
public class PickUpAction implements Action {

    @Override
    public String execute(State state, List<Feature> pickables) {
        Pickable pickable = (Pickable) pickables.get(0);
        //TODO: Check if the feature is an instance of chest and if the chest is unlocked
        //Depending on where the item exists, this shall be the second parameter (Chest, RoomContainer)
        return pickable.pickup(state.getInventory(), state.getCurrentRoom());
    }

    //TODO: The pickup action needs three things, A container where the item will go, a container from where the item will be removed and the item name

    @Override
    public boolean isEligibleForAction(State state, List<Feature> pickables) {
        Pickable pickable = (Pickable) pickables.get(0);
        //TODO: Check if the feature is an instance of chest and if the chest is unlocked
        Item item = (Item) pickable;
        return state.getCurrentRoom().getRoomContainer().isInContainer(item.getName());
    }
}
