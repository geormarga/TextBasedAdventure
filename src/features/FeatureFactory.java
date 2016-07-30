/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import java.util.HashMap;

/**
 *
 * @author Aenaos
 */
public class FeatureFactory {

    private final HashMap<String, Feature> aFeatureMap = new HashMap<>();

    public void registerFeature(String Name, Feature feature) {
        aFeatureMap.put(Name, feature);
    }

    public Feature createFeature(String command) {
        Feature feature = aFeatureMap.get(command);
        return feature;
    }
}
