/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import items.Book;
import items.Bookshelf;
import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class Study extends Room implements Observer{

    public Study() {
        setDescription("There are lots of books here. Unfortunately, I don't have time to spend reading.");
        setHint("There is something curious about this bookshelf.");
    }

/*
    @Override
    public void getMovementMessage() {
        /*
         Book book = (Book) state.getCurrentRoom().getItems().get("book");
         if ("in".equals(attr) && !book.isPulled()) {
         System.out.print("Go where?");
         } else {
         state.setCurrentRoom((Room) state.getCurrentRoom().getRooms().get(attr));
         System.out.println(state.getCurrentRoom().getDescription());
         }
    }
*/

    @Override
    public void update() {
        Book book = (Book) roomItems.getItems().get("book");
        if(book.isPulled()){
            nearbyRooms.addNearbyRoom("in",new HiddenRoom());
            Bookshelf bookshelf = (Bookshelf) roomItems.getItems().get("bookshelf");
            bookshelf.setDescription("A chasm opened on the wall, you can go in.");
        }
    }
    
}
