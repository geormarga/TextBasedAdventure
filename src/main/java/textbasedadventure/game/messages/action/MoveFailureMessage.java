/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.messages.action;

import textbasedadventure.game.messages.IMessage;

/**
 * @author Aenaos
 */
public class MoveFailureMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "You can't go that way!";
    }

}