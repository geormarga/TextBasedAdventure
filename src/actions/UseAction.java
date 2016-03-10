/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Usable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class UseAction implements Action<Usable> {

    @Override
    public void execute(State state, Usable usable) {
        usable.use(state.getActor().getInventory(), state.getCurrentRoom().getRoomItems());
    }
}
