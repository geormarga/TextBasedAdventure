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
public class WrongCommandMessage implements IMessage {

    private String attr;

    @Override
    public void display() {
        System.out.println("I didn't recognise the command.");
    }

}
