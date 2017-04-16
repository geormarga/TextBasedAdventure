/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Examinable;
import items.Item;
import textbasedadventure.State;

/**
 * @author Aenaos
 */
public class ExamineAction implements Action<Examinable> {

    @Override
    public void execute(State state, Examinable examinable) {
        examinable.examine();
    }

    @Override
    public boolean isEligibleForAction(State state, Examinable examinable) {
        Item item = (Item) examinable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName()) || state.getInventory().isInInventory(item.getName());
    }
}
