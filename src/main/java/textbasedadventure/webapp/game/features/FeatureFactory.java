package textbasedadventure.webapp.game.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FeatureFactory {

    @Autowired
    private Map<String, Feature> featureMap;

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
    public Feature getFeature(String name) {
        return featureMap.get(name);
    }
}
