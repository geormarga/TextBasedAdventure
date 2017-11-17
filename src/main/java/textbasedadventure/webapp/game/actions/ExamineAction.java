/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import textbasedadventure.webapp.game.features.Examinable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.State;

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
