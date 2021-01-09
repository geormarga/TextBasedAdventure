/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.features.Usable;
import textbasedadventure.webapp.game.items.containers.Container;
import textbasedadventure.webapp.game.rooms.Room;
import textbasedadventure.webapp.game.items.containers.Inventory;

/**
 * @author Aenaos
 */
@Component("triangular artifact")
public class TriangularArtifact extends Item implements Pickable, Usable {

    public TriangularArtifact() {
        name = "triangular artifact";
        description = "One of the three sun artifacts. It's the shape of a triangle.";
        //featureFactory.registerFeature(this.name, this);
    }

    @Override
    public String pickup(Inventory inventory, Container container) {
        inventory.registerItem(this.name);
        container.unregisterItem(this.name);
        return "You picked up a triangular artifact.";
    }

    @Override
    public String use(Inventory inventory, Room room) {
        room.registerItem(this.name);
        inventory.unregisterItem(this.name);
        //altar you already set the object
        return "Use method";
    }
}
