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
@Component("golden key")
public class GoldenKey extends Item implements Pickable {

    public GoldenKey() {
        name = "golden key";
        description = "With this key you can unlock golden chests";
        //featureFactory.registerFeature(this.name, this);
    }

    @Override
    public String pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        return "You picked up a golden key.";
    }

}
