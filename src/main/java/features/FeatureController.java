/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aenaos
 */
public class FeatureController {

    public List<Feature> getFeatures(List<String> attributes, FeatureFactory featureFactory) {
        List<Feature> features = new LinkedList<>();
        attributes.forEach(attr -> features.add(featureFactory.createFeature(attr)));
        return features;
    }

}
