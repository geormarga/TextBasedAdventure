/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import textbasedadventure.State;

/**
 *
 * @author Aenaos
 * @param <T> Item to do action on
 */
public interface Action<T> {

    boolean execute(State state, T t);

    boolean existsInContext(State state, T t);
}
