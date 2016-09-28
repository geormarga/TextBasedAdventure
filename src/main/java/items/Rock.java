/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import rooms.Room;

/**
 *
 * @author Aenaos
 */
public class Rock extends Item {

    public Rock() {
        name = "rock";
        description = "Lifting the rock revealed a hidden place. There is a golden chest";
    }

    private void createItem(Room room) {
        room.registerItem("elixir");
        room.registerItem("golden chest");
    }
}
