/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Showable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class ShowInventoryAction implements Action<Showable>{

    @Override
    public void execute(State state, Showable showable) {
        showable.show();
    }
}