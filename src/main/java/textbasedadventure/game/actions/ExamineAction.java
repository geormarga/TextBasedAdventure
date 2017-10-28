/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.actions;

import textbasedadventure.game.features.Examinable;
import textbasedadventure.game.items.Item;
import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public class ExamineAction implements Action<Examinable> {

    @Override
    public String execute(State state, Examinable examinable) {
        return examinable.examine();
    }

    @Override
    public boolean isEligibleForAction(State state, Examinable examinable) {
        Item item = (Item) examinable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName()) || state.getInventory().isInInventory(item.getName());
    }
}
