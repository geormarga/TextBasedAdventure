package textbasedadventure.game;

import java.util.ArrayList;
import java.util.List;

public class Command {

    private List<String> attributes;
    private String command;

    public String getCommand() {
        return command;
    }

    /**
     * Method that gets the unedited string
     * and sets the command based on the list of commands given.
     * @param text The user input.
     * @param cmdList The list of available commands.
     */
    void setCommand(String text, List<String> cmdList) {
        for (String value : cmdList) {
            if (text.contains(value + " ")) {
                this.command = value;
                break;
            }
        }
    }

    public List<String> getAttributes() {
        return attributes;
    }

    void setAttributes(String text, List<String> cmdList) {
        this.attributes = new ArrayList<>();
        for (String attr : cmdList) {
            if (text.contains(attr)) {
                this.attributes.add(attr);
                text = text.replace(attr, "").trim();
            }
        }
    }

    void clearValues() {
        this.command = null;
        this.attributes = null;
    }
}
