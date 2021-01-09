package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

@Component("bookshelf")
public class Bookshelf extends Item {

    public Bookshelf() {
        name = "bookshelf";
        description = "Maybe it's one of those trap doors... A book is standing out. More than it should, at least.";
    }


}
