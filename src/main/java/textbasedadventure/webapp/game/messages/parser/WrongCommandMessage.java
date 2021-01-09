package textbasedadventure.webapp.game.messages.parser;

import textbasedadventure.webapp.game.messages.IMessage;

public class WrongCommandMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "I didn't recognise the command.";
    }

}
