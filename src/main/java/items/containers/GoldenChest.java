/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.containers;

import features.FeatureFactory;
import features.Openable;
import items.Item;
import java.util.List;
import textbasedadventure.Inventory;

/**
 *
 * @author Aenaos
 */
public class GoldenChest extends Item implements Openable {

    private List<String> containerItems;
    private boolean open;

    public GoldenChest(FeatureFactory featureFactory) {
        name = "golden chest";
        description = "This chest can be opened with a golden key";
        featureFactory.registerFeature(this.name,this);
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return this.open;
    }

    @Override
    public void open(Inventory inventory) {
        if (inventory.isInInventory("golden key")) {
            this.setOpen(true);
            System.out.println("Chest is open you should probably examine it.");
        }
    }

    public List<String> getContainerItems() {
        return this.containerItems;
    }
    //circularArtifact
    //on open getCurrentRoom & add items to current room 
    //and maybe a list? so that I can show what each chest has in 
    //in the same way remove when something gets picked up
}
