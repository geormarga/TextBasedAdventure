/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Storable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class LoadAction implements Action<Storable> {

    @Override
    public boolean execute(State state, Storable storable) {
        storable.load();
        return true;
    }
}
    