/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pullable;

/**
 * @author Aenaos
 */
@Component("book")
public class Book extends Item implements Pullable {

    private boolean pulled = false;

    public Book() {
        name = "book";
        description = "There's some sort of mechanism linking this particular book to the bookshelf.";
        //featureFactory.registerFeature(this.name, this);
    }

    public boolean isPulled() {
        return pulled;
    }

    private void setPulled(boolean pulled) {
        this.pulled = pulled;
    }

    @Override
    public String pull() {
        this.setPulled(true);
        this.setDescription("You already pulled the book");
        return "A chasm opened on the wall, you can go in.";
    }
}
