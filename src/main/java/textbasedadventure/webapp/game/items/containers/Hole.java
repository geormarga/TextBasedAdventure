/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items.containers;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.items.Item;

/**
 * @author Aenaos
 */
@Component("hole")
public class Hole extends Item {

    public Hole() {
        name = "hole";
        description = "There's a hole on the ground, and what looks to be a torch in it.";
        //featureFactory.registerFeature(this.name, this);
    }
    //torch
}