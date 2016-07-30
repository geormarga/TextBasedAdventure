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
public class LoadSuccessMessage implements IMessage {

    private String attr;

    @Override
    public void display() {
        System.out.println("The game has been loaded , you are ready to play!");
    }

}
