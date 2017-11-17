/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.rooms.Room;
import textbasedadventure.webapp.game.Inventory;

/**
 * @author Aenaos
 */
@Component("sundial")
public class Sundial extends Item implements Pickable {

    public Sundial() {
        name = "sundial";
        description = "It's a sundial.You look closer only to find a line, marking the dial: Ten to two .";
        //featureFactory.registerFeature(this.name, this);
    }

    @Override
    public String pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        return "You picked up a sundial.";
    }

}
