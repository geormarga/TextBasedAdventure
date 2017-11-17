/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.items.containers.CommonChest;
import textbasedadventure.webapp.game.Observer;
import textbasedadventure.webapp.game.State;

import javax.annotation.PostConstruct;

/**
 * @author Aenaos
 */
@Component("castle")
public class Castle extends Room implements Observer {

    @Autowired
    public Castle(Map map) {
        name = "castle";
        description = "You are in the castle yard. You are free to go in, but there is also a cave to the west...";
        hint = "You found a chest on the ground.";
        nearbyRooms = map.getNearbyRooms(name);
        roomItems= map.getRoomItems(name);
    }

    @Override
    public void update(State state) {
        CommonChest chest = (CommonChest) state.getFeatureFactory().createFeature("common chest");
        if (chest.isOpen()) {
            this.registerItem("circular artifact");
            //register in container
            System.out.println("Items in chest:");
            for (String key : chest.getContainerItems()) {
                System.out.println(key + ",");
            }
            System.out.println(".");
        }
    }
}
