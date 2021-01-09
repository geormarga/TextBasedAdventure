package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.State;

public interface Turnable extends Feature {

    String turn(State state);
}
