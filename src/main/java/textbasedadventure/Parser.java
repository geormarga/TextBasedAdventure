/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import messages.IMessage;
import messages.parser.WrongAttributeMessage;
import messages.parser.WrongCommandMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aenaos
 */
class Parser {

    private final CommandList cmdList = new CommandList();
    private IMessage message;

    /**
     * Takes in the user input and checks if it complies with the command structure. Otherwise displays an error message.
     *
     * @param text The user input
     * @return The boolean value that represents the command and attribute validity.
     */
    boolean commandIsValid(String text, Command command) {

        if(text.isEmpty()){
            return false;
        }

        command.setCommand(text, cmdList.getCommands());

        if(!this.isCommand(command.getCommand())){
            message.display();
            return false;
        }

        // Remove command from user input text
        text = text.replace(command.getCommand(), "").trim();

        //
        command.setAttributes(text, cmdList.getAttributes(command.getCommand()));
        if (this.isAttribute(command.getCommand(), command.getAttributes())) {
            return true;
        }

        message.display();
        return false;
    }

    /**
     * Checks whether a command is valid, otherwise sets an error message to be displayed.
     *
     * @param command The command string given by the user
     * @return The boolean value that represents whether the command is valid
     */
    private boolean isCommand(String command) {
        if (cmdList.isVerb(command)) {
            return true;
        }
        this.message = new WrongCommandMessage();
        return false;
    }

    /**
     * Checks whether an attribute is valid, otherwise sets an error message to be displayed.
     *
     * @param attributes The command attributes given by the user
     * @return The boolean value that represents whether each one of the attributes is valid
     */
    private boolean isAttribute(String command, List<String> attributes) {
        if (cmdList.areValidAttributes(command, attributes)) {
            return true;
        }
        this.message = new WrongAttributeMessage();
        return false;
    }
}

