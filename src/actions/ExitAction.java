/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class ExitAction implements Action {

    @Override
    public boolean execute(State state, Object t) {
        return false;
    }

    @Override
    public boolean existsInContext(State state, Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
