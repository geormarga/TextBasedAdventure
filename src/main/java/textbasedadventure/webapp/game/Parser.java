/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.messages.IMessage;
import textbasedadventure.webapp.game.messages.parser.WrongAttributeMessage;
import textbasedadventure.webapp.game.messages.parser.WrongCommandMessage;

import java.util.List;

/**
 * @author Aenaos
 */
@Component
public class Parser {

    private boolean isValid;
    private CommandList cmdList;
    private IMessage message;

    public boolean commandIsValid(){
        return isValid;
    }
    /**
     * Takes in the user input and checks if it complies with the command structure. Otherwise displays an error message.
     *
     * @param text The user input
     * @return The boolean value that represents the command and attribute validity.
     */
    public String getCommandResultMessage(String text, Command command) {

        if (text.isEmpty()) {
            isValid = false;
            return "Command is empty.";
        }

        command.setCommand(text, cmdList.getCommands());
        if (!this.isCommand(command.getCommand())) {

            isValid = false;
            return message.display();
        }

        // Remove command from user input text
        text = text.replace(command.getCommand(), "").trim();

        //
        command.setAttributes(text, cmdList.getAttributes(command.getCommand()));
        if (this.isAttribute(command.getCommand(), command.getAttributes())) {
            isValid = true;
            return "Command is valid";

        }

        isValid = false;
        return message.display();
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
    public Parser(){
        cmdList = new CommandList();
    }
}

