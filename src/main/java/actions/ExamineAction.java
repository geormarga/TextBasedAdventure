/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Examinable;
import items.Item;
import messages.IMessage;
import messages.action.ExamineFailureMessage;
import textbasedadventure.State;

/**
 * @author Aenaos
 */
public class ExamineAction implements Action<Examinable> {

    @Override
    public boolean execute(State state, Examinable examinable) {
        if (examinable != null) {
            examinable.examine();
            return true;
        }
        IMessage message = new ExamineFailureMessage();
        message.display();
        return true;
    }
    /*  Returns true if the string represents an item in the room or an item in the inventory Else returns false.
     */

    @Override
    public boolean existsInContext(State state, Examinable examinable) {
        Item item = (Item) examinable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName()) || state.getInventory().isInInventory(item.getName());
    }
}
