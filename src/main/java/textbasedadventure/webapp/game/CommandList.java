package textbasedadventure.webapp.game;

import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import textbasedadventure.webapp.game.parsing.JSONParser;

public class CommandList {

    private final JSONArray commandList;

    public CommandList() {
        this.commandList = JSONParser.toJsonArray("src/main/resources/CommandList.json", "commands");
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
        return (List<String>) commandList
                .stream()
                .map(cmd -> ((JSONObject) cmd).get("name"))
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    /**
     * Method that gets a command's attributes by providing the command name
     *
     * @param command The string representing a command name
     * @return The contained attributes for the specified command
     */
    List<String> getAttributes(String command) {
        return (List<String>) commandList
                .stream()
                .filter(cmd -> ((JSONObject) cmd).get("name").equals(command))
                .map(cmd -> ((JSONObject) cmd).get("attributes"))
                .findFirst().get();
    }
}
