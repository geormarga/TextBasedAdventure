package textbasedadventure.webapp.game.messages.action;

import textbasedadventure.webapp.game.messages.IMessage;

public class ExamineFailureMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "You look around, but you can't find an item to examine.";
    }

}
