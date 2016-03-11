/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.game;

import messages.IMessage;

/**
 *
 * @author Aenaos
 */
public class PickUpMessage implements IMessage{
    public void display(String text) {
            System.out.println("You picked up a(n)" + text + ".");   
    }
}
