package textbasedadventure;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

class CommandList {

    private NodeList commandList;

    CommandList() {
        this.commandList = XMLParser.toNodeList("CommandList.xml");
    }

    boolean isVerb(String command) {
        return this.getCommands().contains(command);
    }

    /**
     * Method that validates attributes against a commandList which sets which pass and which not
     *
     * @param attributes The user given command attributes
     * @return True if all of the attributes are valid
     */
    boolean areValidAttributes(String command, List<String> attributes) {
        return getAttributes(command).containsAll(attributes) && !attributes.isEmpty();
    }

    /**
     * Method that gets all the available commands to validate against
     *
     * @return A list of the available commands
     */
    List<String> getCommands() {
        List<String> commands = new ArrayList<>();
        List<Element> elements = XMLParser.toElementList(commandList);
        elements.forEach(element -> commands.add(element.getAttribute("name")));
        return commands;
    }

    /**
     * Method that gets a commands's attributes as defined in the xml file
     *
     * @param command The string representing a command name
     * @return The contained attributes for the specified command
     */
    List<String> getAttributes(String command) {
        return XMLParser.getElements(command, commandList);
    }
}
