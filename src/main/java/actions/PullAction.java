/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Pullable;
import items.Item;
import textbasedadventure.State;

/**
 * @author Aenaos
 */
public class PullAction implements Action<Pullable> {

    @Override
    public void execute(State state, Pullable pullable) {
        pullable.pull();
    }

    @Override
    public boolean existsInContext(State state, Pullable pullable) {
        Item item = (Item) pullable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName());
    }
}
