package textbasedadventure.webapp.game.messages.parser;

import textbasedadventure.webapp.game.messages.IMessage;

public class CommandWithoutAttributeMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "You gave a command, without any attributes.";
    }
}
