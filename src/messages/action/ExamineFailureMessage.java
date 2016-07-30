/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.action;

import messages.IMessage;

/**
 *
 * @author Aenaos
 */
public class ExamineFailureMessage implements IMessage {

    private String attr;

    @Override
    public void display() {
        System.out.println("You look around, but you can't find an item to examine.");
    }

}
