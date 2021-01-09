package textbasedadventure.webapp.game.items.containers;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.features.Openable;

@Component("common chest")
public class CommonChest extends Chest implements Openable {

    public CommonChest() {
        name = "common chest";
        description = "If only I had a key...";
        //TODO: Check which items go where
    }

    @Override
    public String open(Inventory inventory) {
        String key = "rusty key";
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
