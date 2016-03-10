/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Lookable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class LookAroundAction implements Action<Lookable> {

    @Override
    public void execute(State state, Lookable lookable) {
        lookable.look();
    }

}
