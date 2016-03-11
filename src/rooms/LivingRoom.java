/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

/**
 *
 * @author Aenaos
 */
public class LivingRoom extends Room {

    public LivingRoom() {

        description = "This is the main Dining Room. The plates on the table indicated that this castle has long been abandonded.";
        hint = "This room is a mess... something happened here!";
        containerType =  new DoesNotContain();
    }
}
