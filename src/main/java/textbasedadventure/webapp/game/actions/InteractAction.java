package textbasedadventure.webapp.game.actions;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.actors.Actor;
import textbasedadventure.webapp.game.features.Interactable;

@Component("interact")
public class InteractAction implements Action<Interactable> {

    @Override
    public String execute(State state, Interactable interactable) {
        return interactable.interact(state.getCurrentRoom());
    }

    @Override
    public boolean isEligibleForAction(State state, Interactable interactable) {
        Actor actor = (Actor) interactable;
        return state.getCurrentRoom().isPresentInRoom(actor.getName());
    }
}
