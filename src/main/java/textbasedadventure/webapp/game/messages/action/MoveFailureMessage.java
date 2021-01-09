package textbasedadventure.webapp.game.messages.action;

import textbasedadventure.webapp.game.messages.IMessage;

public class MoveFailureMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "You can't go that way!";
    }

}
