/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.features.Usable;
import textbasedadventure.webapp.game.rooms.Room;
import textbasedadventure.webapp.game.items.containers.Inventory;

/**
 * @author Aenaos
 */
@Component("torch")
public class Torch extends Item implements Pickable, Usable {

    public Torch() {
        name = "torch";
        description = "A wooden torch that can be used to see in the dark";
        //featureFactory.registerFeature(this.name, this);
    }

    @Override
    public String pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
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
