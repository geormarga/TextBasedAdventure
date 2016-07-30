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
public class NewGameAction implements Action<Storable> {

    @Override
    public boolean execute(State state, Storable loadable) {
        loadable.load();
        return true;
    }

    @Override
    public boolean existsInContext(State state, Storable t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
