/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items.containers;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.features.Openable;

/**
 * @author Aenaos
 */
@Component("silver chest")
public class SilverChest extends Chest implements Openable {

    public SilverChest() {
        name = "silver chest";
        description = "This chest can be opened with a silver key";
        //TODO: Check which items go where
        this.registerItem("rectangular artifact");
        this.registerItem("torn note");
    }

    @Override
    public String open(Inventory inventory) {
        String key = "silver key";
        if (!this.isUnlocked() && !inventory.isInInventory(key)) {
            return "Could not open chest";
        }

        if (inventory.isInInventory(key)) {
            inventory.unregisterItem(key);
            this.setUnlocked(true);
        }

        return this.show();
    }
}
