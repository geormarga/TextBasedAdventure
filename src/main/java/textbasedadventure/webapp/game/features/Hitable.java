package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.rooms.Room;

public interface Hitable extends Feature{

    String hit(Room room);
}
