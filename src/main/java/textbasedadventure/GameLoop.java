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
    private ReadXMLFile readXMLFile;

    void gameLoop(State state) {

        this.setText();
        while (true) {
            if (parser.commandIsValid(text)) {
                readXMLFile.getRoomInDirection(state.getCurrentRoom().getName(), parser.getAttributes());
                Action action = actionController.getAction(parser.getCommand());
                List<Feature> features = featureController.getFeatures(parser.getAttributes(), state.getFeatureFactory());
                actionController.executeAction(action, features, state);
            }
            parser.clearParserValues();
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
        this.readXMLFile = new ReadXMLFile();
    }
}
