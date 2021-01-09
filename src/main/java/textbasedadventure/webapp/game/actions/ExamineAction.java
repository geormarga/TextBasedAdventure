package textbasedadventure.webapp.game.actions;

import java.util.List;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Examinable;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.State;

@Component("examine")
public class ExamineAction implements Action {

    @Override
    public String execute(State state, List<Feature> examinables) {
        Examinable examinable = (Examinable) examinables.get(0);
        return examinable.examine(state.getInventory());
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> examinables) {
        Examinable examinable = (Examinable) examinables.get(0);
        Item item = (Item) examinable;
        return state.getCurrentRoom().getRoomContainer().isInContainer(item.getName()) || state.getInventory().isInInventory(item.getName());
    }
}
