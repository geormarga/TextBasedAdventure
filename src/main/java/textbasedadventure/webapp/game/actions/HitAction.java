package textbasedadventure.webapp.game.actions;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.actors.Actor;
import textbasedadventure.webapp.game.features.Hitable;

@Component("hit")
public class HitAction implements Action<Hitable> {

    @Override
    public String execute(State state, Hitable hitable) {
        return hitable.hit(state.getCurrentRoom());
    }

    @Override
    public boolean isEligibleForAction(State state, Hitable hitable) {
        Actor actor = (Actor) hitable;
        return state.getCurrentRoom().isPresentInRoom(actor.getName());
    }
}
