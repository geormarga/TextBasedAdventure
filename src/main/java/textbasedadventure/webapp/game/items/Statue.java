/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

/**
 * @author Aenaos
 */
@Component("statue")
public class Statue extends Item {

    public Statue() {
        name = "statue";
        description = "A statue honouring the Sun. I guess it's magnificent enough, to have people worshipping it.";
        //featureFactory.registerFeature(this.name, this);
    }

}
