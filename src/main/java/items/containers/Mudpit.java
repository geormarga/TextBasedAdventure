/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.containers;

import features.FeatureFactory;
import items.Item;

/**
 * @author Aenaos
 */
public class Mudpit extends Item {

    public Mudpit(FeatureFactory featureFactory) {
        name = "mudpit";
        description = "There's a key in the mudpit.";
        featureFactory.registerFeature(this.name, this);
    }
}
