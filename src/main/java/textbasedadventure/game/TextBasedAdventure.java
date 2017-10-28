/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game;

/**
 * @author Aenaos
 */
public class TextBasedAdventure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameLoop loop = new GameLoop();
        loop.gameLoop(new State());
    }
}
