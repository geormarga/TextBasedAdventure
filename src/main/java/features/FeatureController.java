/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Aenaos
 */
public class FeatureController {

    /**
     * Method that maps user given attributes with ingame features
     *
     * @param attributes     Validated user given command attributes
     * @param featureFactory The feature factory that contains all ingame objects
     * @return A list of features for the attributes given
     */
    public List<Feature> getFeatures(List<String> attributes, FeatureFactory featureFactory) {
        List<Feature> features = new LinkedList<>();
        attributes.forEach(attr -> features.add(featureFactory.createFeature(attr)));
        return features;
    }

}
