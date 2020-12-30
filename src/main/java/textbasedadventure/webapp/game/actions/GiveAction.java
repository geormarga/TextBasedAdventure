package textbasedadventure.webapp.game.actions;

import java.util.List;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.actors.Actor;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.Giveable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.rooms.Room;

@Component("give")
public class GiveAction implements Action {

    @Override
    public String execute(State state, List<Feature> features) {
        Giveable giveable = (Giveable) features.get(0);
        Item item = (Item) features
                .stream()
                .filter(g -> giveable instanceof Item)
                .findFirst()
                .get();
        return giveable.give(state.getCurrentRoom(), item);
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> features) {
        Actor actor = (Actor) features
                .stream()
                .filter(giveable -> giveable instanceof Actor)
                .filter(giveable -> giveable instanceof Giveable)
                .findFirst()
                .get();
        return state.getCurrentRoom().isPresentInRoom(actor.getName());
    }
}
