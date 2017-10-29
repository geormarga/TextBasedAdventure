/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.actions;

import textbasedadventure.game.features.Feature;
import textbasedadventure.game.State;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aenaos
 */
public class ActionController {

    /**
     * Method that checks if the feature exists in context and then tries to execute the action
     *
     * @param action   Action to be performed
     * @param features Features to perform action on
     * @param state    The state object of the game
     */
    public String executeAction(Action action, List<Feature> features, State state) {
        try {
            features = features.stream().filter(feature -> action.isEligibleForAction(state, feature)).collect(Collectors.toList());
            for (Feature feature : features) {
                return action.execute(state, feature);
            }
        } catch (NullPointerException ex) {
            return "Could not find what you were looking for.";
        } catch (ClassCastException ex) {
            return "Can't perform that action on this item.";
        }
        return "Unknown error";
    }



    /**
     * Method that gets the action from the ActionFactory
     *
     * @param command Name of the action
     * @return The action for that unique name
     */
    public Action getAction(String command) {
        ActionFactory actionFactory = new ActionFactory();
        actionFactory.setActionFactory();
        return actionFactory.createAction(command);
    }
}