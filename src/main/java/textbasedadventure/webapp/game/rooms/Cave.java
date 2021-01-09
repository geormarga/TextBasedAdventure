/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

@Component("cave")
public class Cave extends Room {

    @Autowired
    public Cave(Map map) {
        name = "cave";
        description = "You are in a cave.";
        hint = "Its kinda dark and you can't see well in here, but you can hear someone screaming!";
        roomContainer = new RoomContainer(map.getRoomItems(name));
        this.registerItem("golden chest");
    }

}

