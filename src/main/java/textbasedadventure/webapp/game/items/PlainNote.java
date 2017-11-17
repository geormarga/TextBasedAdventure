/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.FeatureFactory;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.rooms.Room;
import textbasedadventure.webapp.game.Inventory;

/**
 * @author Aenaos
 */
@Component("plain note")
public class PlainNote extends Item implements Pickable {

    public PlainNote(FeatureFactory featureFactory) {

        name = "plain note";
        description = "I do not know if anyone is reading this."
                + "When you will arrive in the hall of Castle , don't go down the stairs. "
                + "For your own safety!";
    }

    @Override
    public String pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        return "You picked up a plain note.";
    }
}
