/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Saveable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class SaveAction implements Action<Saveable> {

    @Override
    public void execute(State state, Saveable saveable) {
        saveable.save(state);
    }

}
