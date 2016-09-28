/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.containers;

import features.Openable;
import items.Item;
import java.util.List;
import textbasedadventure.Inventory;

/**
 *
 * @author Aenaos
 */
public class CommonChest extends Item implements Openable {

    private List<String> containerItems;
    private boolean open;

    public CommonChest() {
        name = "common chest";
        description = "If only I had a key...";
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return this.open;
    }

    @Override
    public void open(Inventory inventory) {
        if (inventory.isInInventory("rusty key")) {
            this.setOpen(true);
            System.out.println("Chest is open you should probably examine it.");
        }
    }
    
    public List<String> getContainerItems(){
        return this.containerItems;
    }
    
}
