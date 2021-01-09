package textbasedadventure.webapp.game.items.containers;

import org.springframework.stereotype.Component;

@Component("hole")
public class Hole extends Container {

    public Hole() {
        name = "hole";
        description = "There's a hole on the ground, and what looks to be a torch in it.";
        this.registerItem("torch");
    }
}
