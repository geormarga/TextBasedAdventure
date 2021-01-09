package textbasedadventure.webapp.game.messages.action;

import textbasedadventure.webapp.game.messages.IMessage;

public class PickUpFailureMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "There isn't such an item in this room.";
    }

}
