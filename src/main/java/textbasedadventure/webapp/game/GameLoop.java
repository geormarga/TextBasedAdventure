package textbasedadventure.webapp.game;

import java.util.List;
import java.util.Scanner;

import textbasedadventure.webapp.game.actions.Action;
import textbasedadventure.webapp.game.actions.ActionController;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.FeatureController;

class GameLoop {

    private String text;
    private final ActionController actionController;
    private final FeatureController featureController;
    private final Parser parser;
    private Command command;
    private Map map;

    void gameLoop(State state) {

        this.setText();
        while (true) {
            this.setText();
            String commandResult = parser.getCommandResultMessage(text, command);
            if (parser.commandIsValid()) {
                // Replace direction with actual room name (e.g. "north" could be replaced with "forest").
                String currentRoomName = state.getCurrentRoom().getName();
                List<String> rooms = map.getRoomInDirection(currentRoomName, command.getAttributes());
                // Select the correct action based on the command given.
                Action action = actionController.getAction(command.getCommand());
                // Select the items the action should be executed on based on the attributes of the command given.
                List<Feature> features = featureController.getFeatures(rooms, state.getFeatureFactory());
                //Clear the command values.
                command.clearValues();
                // Execute the action
                System.out.println(actionController.executeAction(action, features, state));
            } else {
                System.out.println(commandResult);
            }
        }
    }

    private void setText() {
        Scanner scan = new Scanner(System.in);
        this.text = scan.nextLine().toLowerCase();
        this.text = this.text.trim();
    }

    GameLoop() {
        this.actionController = new ActionController();
        this.featureController = new FeatureController();
        this.parser = new Parser();
        this.command = new Command();
    }
}
