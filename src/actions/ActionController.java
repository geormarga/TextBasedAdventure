/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Feature;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class ActionController {

    public boolean executeAction(Action action, Feature feature, State state) {
        return action.execute(state, feature);
    }

    public Action getAction(String command) {
        ActionFactory actionFactory = new ActionFactory();
        actionFactory.setActionFactory();
        return actionFactory.createAction(command);
    }
}
