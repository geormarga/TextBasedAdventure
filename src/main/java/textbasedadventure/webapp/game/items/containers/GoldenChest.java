package textbasedadventure.webapp.game.items.containers;

import textbasedadventure.webapp.game.features.Openable;

public class GoldenChest extends Chest implements Openable {

    public GoldenChest() {
        name = "golden chest";
        description = "This chest can be opened with a golden key";
        //TODO: Check which items go where
        this.registerItem("circular artifact");
        this.registerItem("torn note");
    }

    @Override
    public String open(Inventory inventory) {
        String key = "golden key";
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
