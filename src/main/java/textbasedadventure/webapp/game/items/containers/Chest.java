package textbasedadventure.webapp.game.items.containers;

import java.util.List;

public abstract class Chest extends Container {

    protected List<String> containerItems;
    protected boolean unlocked;

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public boolean isUnlocked() {
        return this.unlocked;
    }

    public List<String> getContainerItems() {
        return this.containerItems;
    }
}
