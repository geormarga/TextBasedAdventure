package textbasedadventure.webapp.game.messages.game;

import textbasedadventure.webapp.game.messages.IMessage;

public class PickUpMessage implements IMessage {

    private String attr;

    PickUpMessage(String attr) {
        this.attr = attr;
    }

    public String display(){ return "You picked up a(n)" + this.attr + ".";
    }
}
