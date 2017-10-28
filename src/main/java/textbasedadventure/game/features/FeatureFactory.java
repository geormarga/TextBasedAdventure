/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.features;

import java.util.HashMap;

/**
 * @author Aenaos
 */
public class FeatureFactory {

    private final HashMap<String, Feature> featureMap = new HashMap<>();

    /**
     * When the state is created, each object registers itself to the featureMap to be retrieved ingame
     *
     * @param Name    Name of the feature (Room|Item|Inventory)
     * @param feature Instance of (Room|Item|Inventory) that implements the Feature Interface
     */
    public void registerFeature(String Name, Feature feature) {
        featureMap.put(Name, feature);
    }

    /**
     * Retrieves a registered feature by its unique name
     *
     * @param name Name of the feature to be retrieved
     * @return Returns the feature that has the specific name (Room|Item|Inventory)
     */
    public Feature createFeature(String name) {
        return featureMap.get(name);
    }
}
