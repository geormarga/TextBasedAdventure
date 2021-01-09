package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.features.Usable;
import textbasedadventure.webapp.game.items.containers.Container;
import textbasedadventure.webapp.game.rooms.Room;
import textbasedadventure.webapp.game.items.containers.Inventory;

@Component("triangular artifact")
public class TriangularArtifact extends Item implements Pickable, Usable {

    public TriangularArtifact() {
        name = "triangular artifact";
        description = "One of the three sun artifacts. It's the shape of a triangle.";
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
