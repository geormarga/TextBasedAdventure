/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Feature;
import textbasedadventure.State;

import java.util.List;

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
    public void executeAction(Action action, List<Feature> features, State state) {
        for (Feature feature : features) {
            if (action.existsInContext(state, feature)) {
                action.execute(state, feature);
            }
        }
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
