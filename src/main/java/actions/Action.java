/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import textbasedadventure.State;

/**
 * @param <T> Item to do action on
 * @author Aenaos
 */
public interface Action<T> {
    /**
     * Method that executes the action for the specified feature
     * @param state The state object of the game
     * @param t The feature the action will be executed upon
     */
    String execute(State state, T t);

    /**
     * Returns true if the string represents an item in the current room. Else returns false.
     *
     * @param state The state object of the game
     * @param t Generic type value (Feature)
     * @return True if the feature exists in context (Room|Inventory)
     */
    boolean isEligibleForAction(State state, T t);
}
