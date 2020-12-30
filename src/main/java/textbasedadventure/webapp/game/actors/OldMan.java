package textbasedadventure.webapp.game.actors;

import org.springframework.stereotype.Component;

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
@Component("old man")
public class OldMan extends Actor implements Interactable, Hitable, Giveable, Examinable {

    private boolean isAlive = true;
    private boolean isIll = true;

    public OldMan() {
        name = "old man";
        description = "You see an old man screaming in pain."
                + "Put him out of his misery.. Try to help him somehow";
        //featureFactory.registerFeature(this.name, this);
    }

    @Override
    public String interact(Room room) {
        System.out.println(this.getDescription());
        if (!isAlive) {
            return this.getDescription();
        } else if (isIll) {
            return "The old man is in a lot of pain and he is trembling. He seems to have a disease. If only I had a potion...";
        } else {
            return "He thanks you";
        }
    }

    private void createItem(Room room) //Create item golden key
    {
        room.registerItem("golden key");
    }

    @Override
    public String hit(Room room) {
        //Create the golden key in the room
        String returnString = "";
        if (isAlive) {
            returnString += "You killed the old man.";
            isAlive = false;
        }
        this.createItem(room);
        this.setDescription("This is the old man's corpse.There is a key in his pocket");
        return returnString + this.getDescription();
    }

    @Override
    public String give(Room room, Item item) {
        //Create the golden key in the room
        String returnString = "";
        if (isIll) {
            if (item instanceof Elixir) {
                returnString += "The potion seems to have cured the old man.";
                isIll = false;
                this.createItem(room);
                this.setDescription("He thanks you.He reaches out for a key in his pocket and hands it over to you");
                return returnString + this.getDescription();
            }
        }
        return this.getDescription();
    }
}
