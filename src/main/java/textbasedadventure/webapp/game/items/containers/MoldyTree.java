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
@Component("moldy tree")
public class MoldyTree extends Item {

    public MoldyTree() {
        name = "moldy tree";
        description = "The tree is pretty moldy and old. Looking down you see an old sundial lying on the ground, near the tree's roots";
        //featureFactory.registerFeature(this.name, this);
    }
}
