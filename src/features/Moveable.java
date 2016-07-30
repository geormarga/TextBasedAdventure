/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public interface Moveable extends Feature {

    public void move(State state);
}
