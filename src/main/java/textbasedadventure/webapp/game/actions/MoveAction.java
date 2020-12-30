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
import textbasedadventure.webapp.game.features.Moveable;
import textbasedadventure.webapp.game.rooms.Room;

/**
 * @author Aenaos
 */
@Component("go")
public class MoveAction implements Action {

    @Override
    public String execute(State state, List<Feature> moveables) {
        Moveable moveable = (Moveable) moveables.get(0);
        return moveable.move(state);
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> moveables) {
        Moveable moveable = (Moveable) moveables.get(0);
        Room room = (Room) moveable;
        return state.getCurrentRoom().getNearbyRooms().contains(room.getName());
    }
}
