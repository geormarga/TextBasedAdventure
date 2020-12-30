/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items.containers;

import textbasedadventure.webapp.game.features.Openable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.Inventory;

import java.util.List;

/**
 * @author Aenaos
 */
public class GoldenChest extends Item implements Openable {

    private List<String> containerItems;
    private boolean open;

    public GoldenChest() {
        name = "golden chest";
        description = "This chest can be opened with a golden key";
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
        //TODO: instance of Golden Key instead
        if (inventory.isInInventory("golden key")) {
            this.setOpen(true);
            return "Chest is open you should probably examine it.";
        }
        return "Could not open chest.";
    }

    public List<String> getContainerItems() {
        return this.containerItems;
    }
    //circularArtifact
    //on open getCurrentRoom & add items to current room 
    //and maybe a list? so that I can show what each chest has in 
    //in the same way remove when something gets picked up
}
