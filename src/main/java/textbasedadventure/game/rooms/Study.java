/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.rooms;

import textbasedadventure.game.features.FeatureFactory;
import textbasedadventure.game.items.Book;
import textbasedadventure.game.items.Bookshelf;
import textbasedadventure.game.Observer;
import textbasedadventure.game.Map;
import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public class Study extends Room implements Observer {

    public Study(FeatureFactory featureFactory, Map map) {
        name = "study";
        description = "There are lots of books here. Unfortunately, I don't have time to spend reading.";
        hint = "There is something curious about this bookshelf.";
        featureFactory.registerFeature(this.name, this);
        this.setNearbyRooms(map.getNearbyRooms(this.name));
        this.setRoomItems(map.getRoomItems(this.name));
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