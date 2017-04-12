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
public class Stand extends Item {

    public Stand(FeatureFactory featureFactory) {
        name = "stand";
        description = "A triangular artifact lies on top of the stand.";
        featureFactory.registerFeature(this.name, this);
    }
}
