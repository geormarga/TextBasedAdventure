package textbasedadventure.webapp.game.exceptions;

public class FeatureNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Could not find what you were looking for.";
    }
}
