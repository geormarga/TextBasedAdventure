/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aenaos
 */
public class TextBasedAdventure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GameLoop loop = new GameLoop();
        try {
            loop.gameLoop(new State());
        } catch (Exception ex) {
            Logger.getLogger(TextBasedAdventure.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
