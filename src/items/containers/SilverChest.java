/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.containers;

import features.Openable;
import items.Item;
import textbasedadventure.Inventory;

/**
 *
 * @author Aenaos
 */
public class SilverChest extends Item implements Openable {

    boolean open;

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
        if (inventory.getElements().containsKey("silver key")) {
            this.setOpen(true);
            System.out.println("Chest is open you should probably examine it.");
        }
    }
    //rectangularArtifact,tornNote

}
