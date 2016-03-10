/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Openable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class OpenAction implements Action<Openable>{

    @Override
    public void execute(State state, Openable openable) {
        openable.open(state.getActor().getInventory());
    }
}