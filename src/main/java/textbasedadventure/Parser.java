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
import java.util.Arrays;
import java.util.List;

/**
 * @author Aenaos
 */
public class Parser {

    private final CommandList cmdList = new CommandList();
    private String command;
    private List<String> attributes;
    private IMessage message;

    /**
     * Takes in the user input and checks if it complies with the command structure. Otherwise displays an error message.
     * @param text The user input
     * @return The boolean value that represents the command and attribute validity.
     */
    boolean CommandIsValid(String text) {

        List<String> readyTokens = new ArrayList<>(Arrays.asList(text.trim().split("\\s+"))); //tokenizes string to list
        //first element is the command
        //search for nouns
        //also search for nouns that interact with each other //hmmm maybe not the best place to check
        command = readyTokens.get(0);
        readyTokens.remove(0);
        attributes = new ArrayList<>();
        attributes.addAll(readyTokens);

        //catch pick up/pickup occasion
        if (command.equals("pick") && attributes.get(0).equals("up")) {
            command = command + attributes.get(0);
            attributes.remove(0);
        }

        if (this.isCommand(command, cmdList) && this.isAttribute(attributes, cmdList)) {
            return true;
        }
        message.display();
        return false;
    }

    /**
     * It checks whether a command is valid, otherwise it sets an error message to be displayed.
     * @param command The command string given by the user
     * @param cmdList The list of commands and attributes class
     * @return The boolean value that represents whether the command is valid
     */
    private boolean isCommand(String command, CommandList cmdList) {
        if (cmdList.isVerb(command)) {
            return true;
        }
        this.message = new WrongCommandMessage();
        return false;
    }

    /**
     * It checks whether an attribute is valid, otherwise it sets an error message to be displayed.
     * @param attributes The command attributes given by the user
     * @param cmdList The list of commands and attributes class
     * @return The boolean value that represents whether each one of the attributes is valid
     */
    private boolean isAttribute(List<String> attributes, CommandList cmdList) {
        if (cmdList.areValidAttributes(attributes)) {
            return true;
        }
        this.message = new WrongAttributeMessage();
        return false;
    }

    public String getCommand() {
        return command;
    }

    List<String> getAttributes() {
        return attributes;
    }
}
