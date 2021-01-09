package textbasedadventure.webapp.game.items.containers;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.features.Openable;

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
