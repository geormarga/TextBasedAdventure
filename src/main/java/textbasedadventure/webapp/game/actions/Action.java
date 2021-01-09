package textbasedadventure.webapp.game.actions;

import java.util.List;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.exceptions.NotEligibleForActionException;
import textbasedadventure.webapp.game.features.Feature;

public interface Action {
    /**
     * Method that executes the action for the specified feature
     * @param state The state object of the game
     * @param features The features the action will be executed upon
     */
    String execute(State state, List<Feature> features);

    /**
     * Returns true if the string represents an item in the current room. Else returns false.
     *
     * @param state The state object of the game
     * @param features Generic type value (Feature)
     * @return True if the features exists in context (Room|Inventory)
     */
    boolean isEligibleForAction(State state, List<Feature> features) throws NotEligibleForActionException;
}
