package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

@Component("altar")
public class Altar extends Item {

    private boolean hasCircular;
    private boolean hasTriangular;
    private boolean hasRectangular;

    public Altar() {
        name = "altar";
        description = "There are three slots for different artifacts to place. \n"
                + "A circular, a rectangular and a triangular one.";
    }

    public boolean hasCircular() {
        return hasCircular;
    }

    public void hasCircular(boolean hasCircular) {
        this.hasCircular = hasCircular;
    }

    public boolean hasTriangular() {
        return hasTriangular;
    }

    public void setTriangular(boolean hasTriangular) {
        this.hasTriangular = hasTriangular;
    }

    public boolean hasRectangular() {
        return hasRectangular;
    }

    public void setRectangular(boolean hasRectangular) {
        this.hasRectangular = hasRectangular;
    }
}
