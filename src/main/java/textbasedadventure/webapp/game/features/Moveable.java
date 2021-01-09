package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.State;

public interface Moveable extends Feature {

    String move(State state);
}
