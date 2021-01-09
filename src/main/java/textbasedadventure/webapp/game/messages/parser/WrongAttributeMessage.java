package textbasedadventure.webapp.game.messages.parser;

import textbasedadventure.webapp.game.messages.IMessage;

public class WrongAttributeMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "The command given is right, but I didn't recognise the attribute.";
    }

}
