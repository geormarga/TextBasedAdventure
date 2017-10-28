/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.messages.game;

import textbasedadventure.game.messages.IMessage;

/**
 * @author Aenaos
 */
public class PickUpMessage implements IMessage {

    private String attr;

    PickUpMessage(String attr) {
        this.attr = attr;
    }

    public String display(){ return "You picked up a(n)" + this.attr + ".";
    }
}
