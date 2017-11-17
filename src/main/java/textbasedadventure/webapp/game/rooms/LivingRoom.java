/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Aenaos
 */
@Component("living room")
public class LivingRoom extends Room {

    public LivingRoom() {
        name = "living room";
        description = "This is the main Dining Room. The plates on the table indicated that this castle has long been abandonded.";
        hint = "This room is a mess... something happened here!";
    }
    @PostConstruct
    private void init(){
        //featureFactory.registerFeature(name, this);
        this.setNearbyRooms(map.getNearbyRooms(name));
        this.setRoomItems(map.getRoomItems(name));
    }
}
