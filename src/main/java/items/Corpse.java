/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.FeatureFactory;

/**
 *
 * @author Aenaos
 */
public class Corpse extends Item {

    public Corpse(FeatureFactory featureFactory) {
        name = "corpse"; 
        description = "Must have been dead for years, can't even tell if it's human or not."
                + " There's a piece of parchment on the corpse.";
        featureFactory.registerFeature(this.name,this);
    }

}
