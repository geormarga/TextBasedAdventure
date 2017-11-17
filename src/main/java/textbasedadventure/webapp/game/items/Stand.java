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
@Component("stand")
public class Stand extends Item {

    public Stand() {
        name = "stand";
        description = "A triangular artifact lies on top of the stand.";
        //featureFactory.registerFeature(this.name, this);
    }
}
