package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

@Component("stand")
public class Stand extends Item {

    public Stand() {
        name = "stand";
        description = "A triangular artifact lies on top of the stand.";
    }
}
