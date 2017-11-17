/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.rooms.Room;

/**
 * @author Aenaos
 */
@Component("rock")
public class Rock extends Item {

    public Rock() {
        name = "rock";
        description = "Lifting the rock revealed a hidden place. There is a golden chest";
        //featureFactory.registerFeature(this.name, this);
    }

    private void createItem(Room room) {
        room.registerItem("elixir");
        room.registerItem("golden chest");
    }
}
