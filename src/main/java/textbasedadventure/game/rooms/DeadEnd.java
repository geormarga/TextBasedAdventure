/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.rooms;

import textbasedadventure.game.features.FeatureFactory;
import textbasedadventure.game.items.Hatch;
import textbasedadventure.game.items.WoodenWheel;
import textbasedadventure.game.items.containers.Hole;
import textbasedadventure.game.Observer;
import textbasedadventure.game.Map;
import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public class DeadEnd extends Room implements Observer {

    public DeadEnd(FeatureFactory featureFactory, Map map) {
        name = "dead end";
        description = "This is the end of the road. There is a switchlike wheel, and a hatch in the room.";
        hint = "While looking arround you stumble upon a hole in the ground.";
        featureFactory.registerFeature(this.name, this);
        this.setNearbyRooms(map.getNearbyRooms(this.name));
        this.setRoomItems(map.getRoomItems(this.name));
    }
    /*
     System.out.println("You must open the hatch first.");
     */

    @Override
    public void update(State state) {
        if (!existsInRoom("torch")) {
            Hole hole = (Hole) state.getFeatureFactory().createFeature("hole");
            hole.setDescription("Just an empty hole...");
        }

        WoodenWheel wheel = (WoodenWheel) state.getFeatureFactory().createFeature("wooden wheel");
        if (wheel.isTurned()) {
            Hatch hatch = (Hatch) state.getFeatureFactory().createFeature("hatch");
            hatch.setOpen(true);
            this.registerItem("hatch");
        }
    }

    private void createItem(State state) {
        if (description.equals("There's a hole on the ground, and what looks to be a torch in it.")) {
            this.registerItem("torch");
        }
    }
}
