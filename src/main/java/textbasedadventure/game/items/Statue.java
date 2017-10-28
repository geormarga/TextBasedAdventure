/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.items;

import textbasedadventure.game.features.FeatureFactory;

/**
 * @author Aenaos
 */
public class Statue extends Item {

    public Statue(FeatureFactory featureFactory) {
        name = "statue";
        description = "A statue honouring the Sun. I guess it's magnificent enough, to have people worshipping it.";
        featureFactory.registerFeature(this.name, this);
    }

}
