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
public class StartAction implements Action{

    @Override
    public boolean execute(State state, Object t) {
       game.start();
    }
    
}
