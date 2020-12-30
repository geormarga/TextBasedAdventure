/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.actions;

import java.util.List;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.Lookable;
import textbasedadventure.webapp.game.rooms.Room;

/**
 * @author Aenaos
 */
@Component("look")
public class LookAroundAction implements Action {

    @Override
    public String execute(State state, List<Feature> lookables) {
        Lookable lookable = (Lookable) lookables.get(0);
        return lookable.look();
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> lookables) {
        Lookable lookable = (Lookable) lookables.get(0);
        Room room = (Room) lookable;
        return state.getCurrentRoom().getName().equals(room.getName());
    }

}
