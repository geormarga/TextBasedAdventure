/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.items.containers;

import textbasedadventure.game.features.FeatureFactory;
import textbasedadventure.game.items.Item;

/**
 * @author Aenaos
 */
public class Hole extends Item {

    public Hole(FeatureFactory featureFactory) {
        name = "hole";
        description = "There's a hole on the ground, and what looks to be a torch in it.";
        featureFactory.registerFeature(this.name, this);
    }
    //torch
}
