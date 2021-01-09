package textbasedadventure.webapp.game.items.containers;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.items.Item;

@Component("moldy tree")
public class MoldyTree extends Item {

    public MoldyTree() {
        name = "moldy tree";
        description = "The tree is pretty moldy and old. Looking down you see an old sundial lying on the ground, near the tree's roots";
    }
}
