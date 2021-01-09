package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

@Component("statue")
public class Statue extends Item {

    public Statue() {
        name = "statue";
        description = "A statue honouring the Sun. I guess it's magnificent enough, to have people worshipping it.";
    }

}
