package textbasedadventure.webapp.game.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.exceptions.NotEligibleForActionException;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.State;

import java.util.List;

@Component
public class ActionController {

    @Autowired
    private ActionFactory actionFactory;
    /**
     * Method that checks if the feature exists in context and then tries to execute the action
     *
     * @param action   Action to be performed
     * @param features Features to perform action on
     * @param state    The state object of the game
     */
    public String executeAction(Action action, List<Feature> features, State state) {
        try {
            action.isEligibleForAction(state, features);
            return action.execute(state, features);
        } catch (NullPointerException ex) {
            return "Could not find what you were looking for.";
        } catch (ClassCastException ex) {
            return "Can't perform that action on this item.";
        } catch (NotEligibleForActionException ex){
            return "Can't perform that action on this item.";
        }catch (Exception ex){
            return ex.getMessage();
        }
    }



    /**
     * Method that gets the action from the ActionFactory
     *
     * @param command Name of the action
     * @return The action for that unique name
     */
    public Action getAction(String command) {
        return actionFactory.createAction(command);
    }
}
