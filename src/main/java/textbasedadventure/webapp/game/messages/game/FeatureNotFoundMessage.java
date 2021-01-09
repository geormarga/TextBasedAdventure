package textbasedadventure.webapp.game.messages.game;

import textbasedadventure.webapp.game.messages.IMessage;

public class FeatureNotFoundMessage implements IMessage {

    private String attr;

    public FeatureNotFoundMessage(String attr) {
        this.attr = attr;
    }


    @Override
    public String display() {
        return "Could not find " + this.attr + ".";
    }

}
