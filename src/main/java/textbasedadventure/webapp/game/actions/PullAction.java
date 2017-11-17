/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pullable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.State;

/**
 * @author Aenaos
 */
@Component("pull")
public class PullAction implements Action<Pullable> {

    @Override
    public String execute(State state, Pullable pullable) {
        return pullable.pull();
    }

    @Override
    public boolean isEligibleForAction(State state, Pullable pullable) {
        Item item = (Item) pullable;
        return state.getCurrentRoom().getRoomItems().contains(item.getName());
    }
}
