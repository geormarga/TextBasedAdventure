package textbasedadventure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class CommandList {

    private HashMap<String, List<String>> commandList;

    CommandList() {
        this.commandList = new HashMap<>();
        ReadXMLFile readXMLFile = new ReadXMLFile();
        List<String> commands = readXMLFile.getCommands();
        for (String command : commands) {
            commandList.put(command, readXMLFile.getAttributes(command));
        }
    }

    private HashMap<String, List<String>> getCommandList() {
        return this.commandList;
    }

    boolean isVerb(String command) {
        return this.getCommandList().containsKey(command);
    }

    /**
     * Method that validates attributes against a commandList which sets which pass and which not
     *
     * @param attributes The user given command attributes
     * @return True if all of the attributes are valid
     */
    boolean areValidAttributes(List<String> attributes) {
        List<String> attrList = new LinkedList<>();
        this.commandList.values().forEach(attrList::addAll);
        return attrList.containsAll(attributes) && !attributes.isEmpty();
    }
}
