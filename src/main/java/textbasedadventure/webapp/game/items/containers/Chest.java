package textbasedadventure.webapp.game.items.containers;

import textbasedadventure.webapp.game.features.Showable;

public abstract class Chest extends Container implements Showable {

    protected boolean unlocked;

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public boolean isUnlocked() {
        return this.unlocked;
    }

    @Override
    public String show() {
        return String.join(",", items);
    }
}
