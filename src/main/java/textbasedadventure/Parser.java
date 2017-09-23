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
public class Parser {

    private final CommandList cmdList = new CommandList();
    private String command;
    private List<String> attributes;
    private IMessage message;
    private ReadXMLFile readXMLFile = new ReadXMLFile();

    /**
     * Takes in the user input and checks if it complies with the command structure. Otherwise displays an error message.
     *
     * @param text The user input
     * @return The boolean value that represents the command and attribute validity.
     */
    boolean commandIsValid(String text) {

        for (String value : readXMLFile.getCommands()) {
            if (text.contains(value + " ")) {
                command = value;
                text = text.replace(value, "").trim();
            }
        }

        attributes = new ArrayList<>();
        for (String attr : readXMLFile.getAttributes(command)) {
            if (text.contains(attr)) {
                attributes.add(attr);
                text = text.replace(attr, "").trim();
            }
        }

        if (this.isCommand(command, cmdList) && this.isAttribute(attributes, cmdList)) {
            return true;
        }
        message.display();
        return false;

    }

    /**
     * Checks whether a command is valid, otherwise sets an error message to be displayed.
     *
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
     * Checks whether an attribute is valid, otherwise sets an error message to be displayed.
     *
     * @param attributes The command attributes given by the user
     * @param cmdList    The list of commands and attributes class
     * @return The boolean value that represents whether each one of the attributes is valid
     */
    private boolean isAttribute(List<String> attributes, CommandList cmdList) {
        if (cmdList.areValidAttributes(attributes)) {
            return true;
        }
        this.message = new WrongAttributeMessage();
        return false;
    }

    void clearParserValues() {
        this.command = null;
        this.attributes = null;
    }

    public String getCommand() {
        return command;
    }

    List<String> getAttributes() {
        return attributes;
    }
}

