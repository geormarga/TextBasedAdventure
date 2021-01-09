package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.features.Usable;
import textbasedadventure.webapp.game.items.containers.Container;
import textbasedadventure.webapp.game.rooms.Room;
import textbasedadventure.webapp.game.items.containers.Inventory;

@Component("torch")
public class Torch extends Item implements Pickable, Usable {

    public Torch() {
        name = "torch";
        description = "A wooden torch that can be used to see in the dark";
    }

    @Override
    public String pickup(Inventory inventory, Container container) {
        inventory.registerItem(this.name);
        container.unregisterItem(this.name);
        return "You picked up a torch.";
    }

    @Override
    public String use(Inventory inventory, Room room) {
        inventory.unregisterItem(this.getName());
        return "You used the torch.";
    }

    /*
     public void use(String attr, State state) {
     setLit(true);
     setDescription("It is lit so that you can see in the dark.");
     System.out.println(this.getDescription());
     }*/

}
