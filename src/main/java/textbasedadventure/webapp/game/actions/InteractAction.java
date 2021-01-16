package textbasedadventure.webapp.game.actions;

import java.util.List;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.actors.Actor;
import textbasedadventure.webapp.game.exceptions.NotEligibleForActionException;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.Interactable;

@Component("interact")
public class InteractAction implements Action {

    @Override
    public String execute(State state, List<Feature> interactables) {
        Interactable interactable = (Interactable) interactables.get(0);
        return interactable.interact(state.getCurrentRoom());
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> interactables) {
        try {
            Interactable interactable = (Interactable) interactables.get(0);
            Actor actor = (Actor) interactable;
            return state.getCurrentRoom().isPresentInRoom(actor.getName());
        } catch (ClassCastException ex) {
            throw new NotEligibleForActionException();
        }
    }
}
