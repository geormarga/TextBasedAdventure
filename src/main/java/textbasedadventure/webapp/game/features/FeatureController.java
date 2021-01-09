package textbasedadventure.webapp.game.features;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class FeatureController {

    /**
     * Method that maps user given attributes with ingame features
     *
     * @param attributes     Validated user given command attributes
     * @param featureFactory The feature factory that contains all ingame objects
     * @return A list of features for the attributes given
     */
    public List<Feature> getFeatures(List<String> attributes, FeatureFactory featureFactory) {
        return attributes.stream().map(featureFactory::getFeature).collect(Collectors.toList());
    }

}
