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
@Component("bookshelf")
public class Bookshelf extends Item {

    public Bookshelf() {
        name = "bookshelf";
        description = "Maybe it's one of those trap doors... A book is standing out. More than it should, at least.";
        //featureFactory.registerFeature(this.name, this);
    }


}
