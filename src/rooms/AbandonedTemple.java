/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class AbandonedTemple extends Room implements Observer{

    public AbandonedTemple() {
        name = "abandoned temple";
        description = "This is the temple of sunlight. Many pilgrims through the years came"
                + " by to witness this enchanted old ruin.";
        hint = "In sight are: A statue and an altar.";
    }

    @Override
    public void update() {
        //each one is set and all together 4 cases
    }
}
