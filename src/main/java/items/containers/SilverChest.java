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
public class SilverChest extends Item implements Openable {

    private List<String> containerItems;
    private boolean open;

    public SilverChest() {
        name = "silver chest";
        description = "This chest can be opened with a silver key";
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return this.open;
    }

    @Override
    public void open(Inventory inventory) {
        if (inventory.isInInventory("silver key")) {
            this.setOpen(true);
            System.out.println("Chest is open you should probably examine it.");
        }
    }
    
    public List<String> getContainerItems(){
        return this.containerItems;
    }
    
    //rectangularArtifact,tornNote

}
