package textbasedadventure.webapp.game.actions;

import java.util.List;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.actors.Actor;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.Hitable;

@Component("hit")
public class HitAction implements Action {

    @Override
    public String execute(State state, List<Feature> hitables) {
        Hitable hitable = (Hitable) hitables.get(0);
        return hitable.hit(state.getCurrentRoom());
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> hitables) {
        Hitable hitable = (Hitable) hitables.get(0);
        Actor actor = (Actor) hitable;
        return state.getCurrentRoom().isPresentInRoom(actor.getName());
    }
}
