/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

/**
 * @author Aenaos
 */
@Component("water")
public class Water extends Item {

    public Water() {
        name = "water";
        description = "A lot of water.";
        //featureFactory.registerFeature(this.name, this);
    }

}
