package textbasedadventure.webapp.game.items.containers;

import java.util.ArrayList;
import java.util.List;

import textbasedadventure.webapp.game.items.Item;

public abstract class Container extends Item {
    protected String name;
    protected List<String> items = new ArrayList<>();

    public boolean isInContainer(String item) {
        return items.contains(item);
    }

    public void registerItem(String itemName) {
        items.add(itemName);
    }

    public void unregisterItem(String itemName) {
        items.remove(itemName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
