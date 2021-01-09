/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items.containers;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.items.Item;

/**
 * @author Aenaos
 */
@Component("mud pit")
public class Mudpit extends Item {

    public Mudpit() {
        name = "mud pit";
        description = "There's a key in the mudpit.";
    }
}
