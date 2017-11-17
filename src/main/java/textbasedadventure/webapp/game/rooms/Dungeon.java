/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Observer;
import textbasedadventure.webapp.game.State;

import javax.annotation.PostConstruct;

/**
 * @author Aenaos
 */
@Component
public class Dungeon extends Room implements Observer {

    public Dungeon() {
        name = "dungeon";
        description = "This must be a dungeon, by the looks of it many people drew their final breath here...";
        hint = "There's a musty corpse on the ground";
    }
    @PostConstruct
    private void init(){
        //featureFactory.registerFeature(name, this);
        this.setNearbyRooms(map.getNearbyRooms(name));
        this.setRoomItems(map.getRoomItems(name));
    }

    @Override
    public void update(State state) {
        //
    }

    @Override
    public String getMovementMessage() {
        // if ("down".equals(attr)
        return "The staircase collapsed, and you died!\n\nGame Over\n";
        //action.act(, state);
    }
}
