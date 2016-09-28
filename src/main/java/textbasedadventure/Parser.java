/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import java.util.ArrayList;
import java.util.StringTokenizer;
import messages.IMessage;
import messages.parser.WrongAttributeMessage;
import messages.parser.WrongCommandMessage;
import messages.parser.CommandWithoutAttributeMessage;

/**
 *
 * @author Aenaos
 */
public class Parser {

    
    private final CommandList cmdList = new CommandList();
    private String command;
    private String attr;

    public boolean CommandIsValid(String text, State state) {

        Boolean isValid = false;
        String split1, split2;

        StringTokenizer tokenizer = new StringTokenizer(text, " ");
        ArrayList<String> readyTokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            readyTokens.add(tokenizer.nextToken());
        }
        switch (readyTokens.size()) {
            case 1:
                split1 = readyTokens.get(0);
                split2 = "";
                break;
            case 2:
                split1 = readyTokens.get(0);
                split2 = readyTokens.get(1);
                break;
            case 3:
                split1 = readyTokens.get(0);
                split2 = readyTokens.get(1) + readyTokens.get(2);
                break;
            case 4:
                split1 = readyTokens.get(0) + readyTokens.get(1);
                split2 = readyTokens.get(2) + readyTokens.get(3);
                break;
            default:
                return false;
        }
        if (isCommandWithAttr(split1, split2, state)) {
            this.command = split1;
            this.attr = cmdList.getCorrectAttribute(split2);
            isValid = true;
        }
        return isValid;
    }

    /*
     Checks if string is an attribute ,if not returns info message.
     */
    public boolean isCommandWithAttr(String command, String attr, State state) {
        boolean cmdCheck = cmdList.isVerb(command);
        boolean attrCheck = cmdList.isAttr(attr, state);
        boolean attrEmpty = attr.isEmpty();
        this.getParsingMessage(cmdCheck, attrCheck, attrEmpty);
        return (cmdCheck && attrCheck);
    }

    /*
     Handles appropriate parsing message to show
     */
    public void getParsingMessage(boolean cmdCheck, boolean attrCheck, boolean attrEmpty) {

        if (!cmdCheck) {
            IMessage message = new WrongCommandMessage();
            message.display();
        } else {
            if (!attrCheck) {
                IMessage message = new WrongAttributeMessage();
                message.display();
            }
            if (attrEmpty) {
                IMessage message = new CommandWithoutAttributeMessage();
                message.display();
            }
        }
    }

    public String getCommand() {
        return command;
    }

    public String getAttr() {
        return attr;
    }
}
