/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class FeatureController {

    public Feature getFeature(String attr, FeatureFactory featureFactory, State state) {
        return featureFactory.createFeature(attr);

    }

}
