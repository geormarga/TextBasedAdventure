/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.messages.parser;

import textbasedadventure.webapp.game.messages.IMessage;

/**
 * @author Aenaos
 */
public class WrongCommandMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "I didn't recognise the command.";
    }

}