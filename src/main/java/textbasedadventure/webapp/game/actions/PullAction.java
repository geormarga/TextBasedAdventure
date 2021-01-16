package textbasedadventure.webapp.game.actions;

import java.util.List;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.exceptions.NotEligibleForActionException;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.Pullable;
import textbasedadventure.webapp.game.items.Item;

@Component("pull")
public class PullAction implements Action {

    @Override
    public String execute(State state, List<Feature> pullables) {
        Pullable pullable = (Pullable) pullables.get(0);
        return pullable.pull();
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> pullables) {
        try {
            Pullable pullable = (Pullable) pullables.get(0);
            Item item = (Item) pullable;
            return state.getCurrentRoom().getRoomContainer().isInContainer(item.getName());
        } catch (ClassCastException ex) {
            throw new NotEligibleForActionException();
        }
    }
}
