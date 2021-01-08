/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;

/**
 * @author Aenaos
 */
@Component("hall")
public class Hall extends Room {

    @Autowired
    public Hall(Map map) {
        name = "hall";
        description = "You went inside the Castle. It's vast halls seem haunted";
        hint = "You can see some rooms left and right ... and stairs heading down.";
        roomItems = map.getRoomItems(name);
    }
}
