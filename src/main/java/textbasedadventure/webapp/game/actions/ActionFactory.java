/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import java.util.HashMap;

/**
 * @author Aenaos
 */
class ActionFactory {

    private final HashMap<String, Action> actionMap = new HashMap<>();

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

    /**
     * Initializes the actionMap
     */
    void setActionFactory() {
        this.registerAction("examine", new ExamineAction());
        this.registerAction("go", new MoveAction());
        this.registerAction("look", new LookAroundAction());
        this.registerAction("show", new ShowInventoryAction());
        this.registerAction("start", new MoveAction());
        this.registerAction("pick up", new PickUpAction());
        this.registerAction("open", new OpenAction());
        this.registerAction("pull", new PullAction());
        this.registerAction("turn", new TurnAction());
        this.registerAction("use", new UseAction());
    }
}
