/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import actions.Action;
import actions.ActionController;
import features.Feature;
import features.FeatureController;

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

    void gameLoop(State state) {

        this.setText();
        while (true) {
            boolean commandIsValid = parser.commandIsValid(text, command);
            if (commandIsValid) {
                // Replace direction with actual room name (e.g. "north" could be replaced with "forest").
                String currentRoomName = state.getCurrentRoom().getName();
                Map map = state.getMap();
                map.getRoomInDirection(currentRoomName, command.getAttributes());
                // Select the correct action based on the command given.
                Action action = actionController.getAction(command.getCommand());
                // Select the items the action should be executed on based on the attributes of the command given.
                List<Feature> features = featureController.getFeatures(command.getAttributes(), state.getFeatureFactory());
                // Execute the action
                actionController.executeAction(action, features, state);
            }
            command.clearValues();
            this.setText();
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
