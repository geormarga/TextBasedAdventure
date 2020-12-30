package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.rooms.Room;

public interface Giveable extends Feature{

    String give(Room room);
}
