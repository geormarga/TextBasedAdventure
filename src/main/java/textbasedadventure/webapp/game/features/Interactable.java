package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.rooms.Room;

public interface Interactable extends Feature{

    String interact(Room room);
}
