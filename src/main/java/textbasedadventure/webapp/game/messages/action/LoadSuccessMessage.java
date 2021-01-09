package textbasedadventure.webapp.game.messages.action;

import textbasedadventure.webapp.game.messages.IMessage;

public class LoadSuccessMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "The game has been loaded , you are ready to play!";
    }

}
