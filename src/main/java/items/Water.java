/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.FeatureFactory;

/**
 * @author Aenaos
 */
public class Water extends Item {

    public Water(FeatureFactory featureFactory) {
        name = "water";
        description = "A lot of water.";
        featureFactory.registerFeature(this.name, this);
    }

}
