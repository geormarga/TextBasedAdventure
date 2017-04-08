/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Feature;
import messages.IMessage;
import messages.game.FeatureNotFoundMessage;
import textbasedadventure.State;

import java.util.List;

/**
 *
 * @author Aenaos
 */
public class ActionController {

    public boolean executeAction(Action action, List<Feature> features, State state) {
        if (action.existsInContext(state, features)) {
            return action.execute(state, features);
        } else {
            IMessage message = new FeatureNotFoundMessage("feature");
            message.display();
            return true;
        }
    }

    public Action getAction(String command) {
        ActionFactory actionFactory = new ActionFactory();
        actionFactory.setActionFactory();
        return actionFactory.createAction(command);
    }
}
