/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.action;

import messages.IMessage;

/**
 * @author Aenaos
 */
public class LoadFailureMessage implements IMessage {

    private String attr;

    @Override
    public String display() {
        return "Could not load the game, absence of file.";
    }

}
