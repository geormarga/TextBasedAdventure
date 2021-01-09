/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.Map;

@Component("castle")
public class Castle extends Room {

    @Autowired
    public Castle(Map map) {
        name = "castle";
        description = "You are in the castle yard. You are free to go in, but there is also a cave to the west...";
        hint = "You found a chest on the ground.";
        roomItems = map.getRoomItems(name);
        this.registerItem("common chest");
    }
}
