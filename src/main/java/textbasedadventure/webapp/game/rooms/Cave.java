/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.items.containers.GoldenChest;
import textbasedadventure.webapp.game.Observer;
import textbasedadventure.webapp.game.State;

import javax.annotation.PostConstruct;

/**
 * @author Aenaos
 */
@Component("cave")
public class Cave extends Room implements Observer {

    @Autowired
    public Cave(Map map) {
        name = "cave";
        description = "You are in a cave.";
        hint = "Its kinda dark and you can't see well in here, but you can hear someone screaming!";
        nearbyRooms = map.getNearbyRooms(name);
        roomItems= map.getRoomItems(name);
    }

    @Override
    public void update(State state) {
        GoldenChest chest = (GoldenChest) state.getFeatureFactory().createFeature("golden chest");
        if (chest.isOpen()) {

            this.registerItem("torn note");
            this.registerItem("circular artifact");
            chest.getContainerItems().add("torn note");
            chest.getContainerItems().add("circular artifact");

            System.out.println("Items in chest:");
            for (String key : chest.getContainerItems()) {
                System.out.println(key + ",");
            }
            System.out.println(".");
        }
    }
}

