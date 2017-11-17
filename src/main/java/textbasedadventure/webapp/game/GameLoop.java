/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game;

import textbasedadventure.webapp.game.actions.Action;
import textbasedadventure.webapp.game.actions.ActionController;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.FeatureController;

import java.util.List;
import java.util.Scanner;

/**
 * @author Aenaos
 */
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
                map.getRoomInDirection(currentRoomName, command.getAttributes());
                // Select the correct action based on the command given.
                Action action = actionController.getAction(command.getCommand());
                // Select the items the action should be executed on based on the attributes of the command given.
                List<Feature> features = featureController.getFeatures(command.getAttributes(), state.getFeatureFactory());
                //Clear the command values.
                command.clearValues();
                // Execute the action
                System.out.println(actionController.executeAction(action, features, state));
            }else{
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
