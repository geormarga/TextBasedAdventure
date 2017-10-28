/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.containers;

import features.FeatureFactory;
import features.Openable;
import items.Item;
import textbasedadventure.Inventory;

import java.util.List;

/**
 *
 * @author Aenaos
 */
public class SilverChest extends Item implements Openable {

    private List<String> containerItems;
    private boolean open;

    public SilverChest(FeatureFactory featureFactory) {
        name = "silver chest";
        description = "This chest can be opened with a silver key";
        featureFactory.registerFeature(this.name,this);
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return this.open;
    }

    @Override
    public String open(Inventory inventory) {
        if (inventory.isInInventory("silver key")) {
            this.setOpen(true);
            return "Chest is open you should probably examine it.";
        }
        return "Could not open chest";
    }
    
    public List<String> getContainerItems(){
        return this.containerItems;
    }
    
    //rectangularArtifact,tornNote

}
