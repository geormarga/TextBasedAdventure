/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Loadable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class LoadAction implements Action<Loadable> {

    @Override
    public void execute(State state, Loadable loadable) {
        loadable.load();
    }
}
    