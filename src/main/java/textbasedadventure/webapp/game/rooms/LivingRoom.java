/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;

import javax.annotation.PostConstruct;

/**
 * @author Aenaos
 */
@Component("living room")
public class LivingRoom extends Room {

    @Autowired
    public LivingRoom(Map map) {
        name = "living room";
        description = "This is the main Dining Room. The plates on the table indicated that this castle has long been abandoned.";
        hint = "This room is a mess... something happened here!";
        roomItems= map.getRoomItems(name);
    }
}
