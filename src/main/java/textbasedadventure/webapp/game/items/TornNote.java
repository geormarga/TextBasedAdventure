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
@Component("torn note")
public class TornNote extends Item implements Pickable {

    public TornNote() {
        name = "torn note";
        description = "To succeed in the quest of thee, you must find artifacts three ...";
    }

    @Override
    public String pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        return "You picked up a torn note.";
    }
}