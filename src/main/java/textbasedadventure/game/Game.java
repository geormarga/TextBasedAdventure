package textbasedadventure.game;

import textbasedadventure.game.actions.Action;
import textbasedadventure.game.actions.ActionController;
import textbasedadventure.game.features.Feature;
import textbasedadventure.game.features.FeatureController;

import java.util.List;

public class Game {
    private String text;
    private final ActionController actionController;
    private final FeatureController featureController;
    private final Parser parser;
    private Command command;

    public String getDescription(State state,String text) {

        this.setText(text);
        String commandResult = parser.getCommandResultMessage(text, command);
        if (parser.commandIsValid()) {
            // Replace direction with actual room name (e.g. "north" could be replaced with "forest").
            String currentRoomName = state.getCurrentRoom().getName();
            Map map = state.getMap();
            map.getRoomInDirection(currentRoomName, command.getAttributes());
            // Select the correct action based on the command given.
            Action action = actionController.getAction(command.getCommand());
            // Select the items the action should be executed on based on the attributes of the command given.
            List<Feature> features = featureController.getFeatures(command.getAttributes(), state.getFeatureFactory());
            //Clear the command values.
            command.clearValues();
            // Execute the action
            return actionController.executeAction(action, features, state);
        }else{
            return commandResult;
        }
    }


    private void setText(String text) {
        this.text = text.toLowerCase();
        this.text = this.text.trim();
    }

    public Game() {
        this.actionController = new ActionController();
        this.featureController = new FeatureController();
        this.parser = new Parser();
        this.command = new Command();
    }
}