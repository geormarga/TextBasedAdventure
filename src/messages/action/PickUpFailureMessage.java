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
public class PickUpFailureMessage implements IMessage {

    @Override
    public void display(String text) {
        System.out.println("There isn't such an item in this room.");
    }

}
