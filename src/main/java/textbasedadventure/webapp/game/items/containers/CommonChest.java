/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items.containers;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Openable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.Inventory;

import java.util.List;

/**
 * @author Aenaos
 */
@Component("common chest")
public class CommonChest extends Item implements Openable {

    private List<String> containerItems;
    private boolean open;

    public CommonChest() {
        name = "common chest";
        description = "If only I had a key...";
        //featureFactory.registerFeature(this.name, this);
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return this.open;
    }

    @Override
    public String open(Inventory inventory) {
        if (inventory.isInInventory("rusty key")) {
            this.setOpen(true);
            return "Chest is open you should probably examine it.";
        }
        return "Could not open chest";
    }

    public List<String> getContainerItems() {
        return this.containerItems;
    }

}
