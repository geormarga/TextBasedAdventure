package textbasedadventure.webapp.game;

public class TextBasedAdventure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameLoop loop = new GameLoop();
        loop.gameLoop(new State());
    }
}
