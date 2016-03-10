/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Moveable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class MoveAction implements Action<Moveable>{

    @Override
    public void execute(State state, Moveable moveable) {
        moveable.move(state);

    }

}
