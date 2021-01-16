package textbasedadventure.webapp.game.exceptions;

public class NotEligibleForActionException extends RuntimeException {

    @Override
    public String getMessage() {
        return  "Can't perform that action on this item.";
    }
}
