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
import java.util.Scanner;

/**
 *
 * @author Aenaos
 */
public class GameLoop {

    private String text;
    private final ActionController actionController;
    private final FeatureController featureController;
    private final Parser parser;
    private boolean canContinue = true;

    public void gameLoop(State state) throws Exception {

        this.setText();
        while (canContinue) {
            if (parser.CommandIsValid(text)) {
                    Feature feature = featureController.getFeature(parser.getAttr(),state.getFeatureFactory());
                    Action action = actionController.getAction(parser.getCommand());
                    canContinue = actionController.executeAction(action, feature, state);
            }
            this.setText();
        }
    }

    public void setText() {
        Scanner scan = new Scanner(System.in);
        this.text = scan.nextLine().toLowerCase();
        this.text = this.text.trim();
    }

    public GameLoop() {
        this.actionController = new ActionController();
        this.featureController = new FeatureController();
        this.parser = new Parser();

    }
}
