/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.features;

import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public interface Turnable extends Feature {

    String turn(State state);
}