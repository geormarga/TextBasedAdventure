/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.FeatureFactory;
import features.Pickable;
import features.Usable;
import rooms.Room;
import textbasedadventure.Inventory;

/**
 * @author Aenaos
 */
public class TriangularArtifact extends Item implements Pickable, Usable {

    public TriangularArtifact(FeatureFactory featureFactory) {
        name = "triangular artifact";
        description = "One of the three sun artifacts. It's the shape of a triangle.";
        featureFactory.registerFeature(this.name, this);
    }

    @Override
    public void pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        System.out.println("You picked up a triangular artifact.");
    }

    @Override
    public void use(Inventory inventory, Room room) {
        room.registerItem(this.name);
        inventory.unregisterItem(this.name);
        //altar you already set the object
    }
}
