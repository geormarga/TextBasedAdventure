/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Pickable;
import textbasedadventure.Inventory;
import textbasedadventure.RoomItems;

/**
 *
 * @author Aenaos
 */
public class TornNote extends Item implements Pickable {

    public TornNote() {
        this.setName("torn note");
        setDescription("To succeed in the quest of thee, you must find artifacts three ...");
    }
    
    @Override
    public void pickup(Inventory inventory, RoomItems roomItems){
        inventory.addItemToInventory(this);
        roomItems.removeItemFromRoom(this); 
        System.out.println("You picked up a torn note.");
    }
}
