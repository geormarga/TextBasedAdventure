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
 *
 * @author Aenaos
 */
@Component("silver chest")
public class SilverChest extends Item implements Openable {

    private List<String> containerItems;
    private boolean open;

    public SilverChest() {
        name = "silver chest";
        description = "This chest can be opened with a silver key";
        //featureFactory.registerFeature(this.name,this);
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
