/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.parser;

import messages.IMessage;

/**
 * @author Aenaos
 */
public class WrongAttributeMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "The command given is right, but I didn't recognise the attribute.";
    }

}
