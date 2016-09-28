/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.HashMap;

/**
 *
 * @author Aenaos
 */
public class ActionFactory {

    private final HashMap<String, Action> anActionMap = new HashMap<>();

    public void registerAction(String Name, Action action) {
        anActionMap.put(Name, action);
    }

    public Action createAction(String command) {
        Action action = anActionMap.get(command);
        return action;
    }

    public void setActionFactory() {
        this.registerAction("examine", new ExamineAction());
        this.registerAction("go", new MoveAction());
        this.registerAction("look", new LookAroundAction());
        this.registerAction("show", new ShowInventoryAction());
        this.registerAction("start", new MoveAction());
        this.registerAction("pickup", new PickUpAction());
        this.registerAction("open", new OpenAction());
        this.registerAction("pull", new PullAction());
        this.registerAction("turn", new TurnAction());
        this.registerAction("use", new UseAction());
    }

}
