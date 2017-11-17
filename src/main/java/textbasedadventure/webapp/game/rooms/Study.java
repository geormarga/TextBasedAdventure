/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.Observer;
import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.items.Book;
import textbasedadventure.webapp.game.items.Bookshelf;

/**
 * @author Aenaos
 */
@Component("study")
public class Study extends Room implements Observer {

    @Autowired
    public Study(Map map) {
        name = "study";
        description = "There are lots of books here. Unfortunately, I don't have time to spend reading.";
        hint = "There is something curious about this bookshelf.";
        nearbyRooms = map.getNearbyRooms(name);
        roomItems = map.getRoomItems(name);
    }

    @Override
    public void update(State state) {
        Book book = (Book) state.getFeatureFactory().createFeature("book");
        if (book.isPulled()) {
            this.registerRoom("hidden room");
            Bookshelf bookshelf = (Bookshelf) state.getFeatureFactory().createFeature("bookshelf");
            bookshelf.setDescription("A chasm opened on the wall, you can go in.");
        }
    }

}
