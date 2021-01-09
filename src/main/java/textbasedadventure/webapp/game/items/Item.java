package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.items.containers.Inventory;
import textbasedadventure.webapp.game.features.Examinable;

import java.io.Serializable;

@Component
public abstract class Item implements Examinable, Serializable {

    protected String name;
    protected String description;

    @Override
    public String examine(Inventory inventory) {
        return description;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
