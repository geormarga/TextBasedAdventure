/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.Containable;
import items.Book;
import items.Bookshelf;
import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class Study extends Room implements Observer {

    public Study() {
        description = "There are lots of books here. Unfortunately, I don't have time to spend reading.";
        hint = "There is something curious about this bookshelf.";
        containerType = (Containable) new DoesNotContain();
    }

    @Override
    public void update() {
        Book book = (Book) roomItems.getElements().get("book");
        if (book.isPulled()) {
            nearbyRooms.addElement("in", new HiddenRoom());
            Bookshelf bookshelf = (Bookshelf) roomItems.getElements().get("bookshelf");
            bookshelf.setDescription("A chasm opened on the wall, you can go in.");
        }
    }

}
