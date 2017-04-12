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
public class MoldyTree extends Item {

    public MoldyTree(FeatureFactory featureFactory) {
        name = "moldy tree";
        description = "The tree is pretty moldy and old. Looking down you see an old sundial lying on the ground, near the tree's roots";
        featureFactory.registerFeature(this.name, this);
    }
}
