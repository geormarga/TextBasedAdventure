package textbasedadventure.webapp.game.messages.action;

import textbasedadventure.webapp.game.messages.IMessage;

public class LoadFailureMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "Could not load the game, absence of file.";
    }

}
