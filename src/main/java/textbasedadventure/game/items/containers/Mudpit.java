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
public class Mudpit extends Item {

    public Mudpit(FeatureFactory featureFactory) {
        name = "mud pit";
        description = "There's a key in the mudpit.";
        featureFactory.registerFeature(this.name, this);
    }
}
