package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.items.Hatch;
import textbasedadventure.webapp.game.items.WoodenWheel;
import textbasedadventure.webapp.game.items.containers.Hole;
import textbasedadventure.webapp.game.Observer;
import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

@Component("dead end")
public class DeadEnd extends Room implements Observer {

    @Autowired
    public DeadEnd(Map map) {
        name = "dead end";
        description = "This is the end of the road. There is a switchlike wheel, and a hatch in the room.";
        hint = "While looking arround you stumble upon a hole in the ground.";
        roomContainer = new RoomContainer(map.getRoomItems(name));

    }
    /*
     System.out.println("You must open the hatch first.");
     */

    @Override
    public void update(State state) {
        if (!existsInRoom("torch")) {
            Hole hole = (Hole) state.getFeatureFactory().getFeature("hole");
            hole.setDescription("Just an empty hole...");
        }

        WoodenWheel wheel = (WoodenWheel) state.getFeatureFactory().getFeature("wooden wheel");
        if (wheel.isTurned()) {
            Hatch hatch = (Hatch) state.getFeatureFactory().getFeature("hatch");
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
