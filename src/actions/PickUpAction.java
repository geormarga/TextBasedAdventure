/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Pickable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class PickUpAction implements Action<Pickable> {

    @Override
    public void execute(State state, Pickable pickable) {
        pickable.pickup(state.getActor().getInventory(), state.getCurrentRoom().getRoomItems());
    }
}
