/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.messages.game;

import textbasedadventure.webapp.game.messages.IMessage;

/**
 * @author Aenaos
 */
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
