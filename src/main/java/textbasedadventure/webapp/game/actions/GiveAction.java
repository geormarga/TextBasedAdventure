package textbasedadventure.webapp.game.actions;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.actors.Actor;
import textbasedadventure.webapp.game.features.Giveable;

@Component("give")
public class GiveAction implements Action<Giveable> {

    @Override
    public String execute(State state, Giveable giveable) {
        return giveable.give(state.getCurrentRoom());
    }

    @Override
    public boolean isEligibleForAction(State state, Giveable giveable) {
        Actor actor = (Actor) giveable;
        return state.getCurrentRoom().isPresentInRoom(actor.getName());
    }
}
