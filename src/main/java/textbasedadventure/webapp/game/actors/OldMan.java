package textbasedadventure.webapp.game.actors;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.Inventory;
import textbasedadventure.webapp.game.features.Examinable;
import textbasedadventure.webapp.game.features.Giveable;
import textbasedadventure.webapp.game.features.Hitable;
import textbasedadventure.webapp.game.features.Interactable;
import textbasedadventure.webapp.game.items.Elixir;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.rooms.Room;

/**
 * @author Aenaos
 */
@Component("oldman")
public class OldMan extends Actor implements Interactable, Hitable, Giveable, Examinable {

    private boolean isAlive = true;
    private boolean isIll = true;
    private Inventory inventory;

    public OldMan() {
        name = "old man";
        description = "The old man is in a lot of pain and he is trembling. He seems to have a disease. If only I had a potion...";
        inventory = new Inventory();
        inventory.registerItem("golden key");
    }

    @Override
    public String interact(Room room) {
        return this.getDescription();
    }

    @Override
    public String hit(Room room) {
        String returnString = "";
        if (isAlive) {
            returnString += "You killed the old man. ";
            isAlive = false;
        }
        this.setDescription("This is the old man's corpse. I wonder if he carried anything on him...");
        return returnString + this.getDescription();
    }

    @Override
    public String give(Inventory inventory, Item item) {
        if (isIll) {
            if (item instanceof Elixir) {
                isIll = false;
                inventory.unregisterItem("elixir");
                inventory.registerItem("golden key");
                this.inventory.unregisterItem("golden key");
                this.setDescription("The potion cured the old man. He thanks you for saving his life.");
                return this.getDescription() + " He reaches out for a key in his pocket and hands it over to you.";
            }
        }
        return this.getDescription();
    }

    @Override
    public String examine(Inventory inventory) {
        if (!isAlive && this.inventory.isInInventory("golden key")) {
            inventory.registerItem("golden key");
            this.inventory.unregisterItem("golden key");
            this.setDescription("This is the old man's corpse. There's nothing on it...");
        }
        return this.getDescription();
    }
}
