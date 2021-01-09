package textbasedadventure.webapp.game.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
class ActionFactory {

    @Autowired
    private Map<String, Action> actionMap;

    /**
     * Method that creates a mapping for each action <UniqueName,Action>
     *
     * @param name   Unique name of the action
     * @param action Instance of an command that implements the Action Interface
     */
    private void registerAction(String name, Action action) {
        actionMap.put(name, action);
    }

    /**
     * Retrieves a registered action by its unique name
     *
     * @param command Name of the action to be retrieved
     * @return Returns the action that has the specific name
     */
    Action createAction(String command) {
        return actionMap.get(command);
    }
}
