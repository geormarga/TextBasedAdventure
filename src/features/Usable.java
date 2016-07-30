/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import rooms.Room;
import textbasedadventure.Inventory;

/**
 *
 * @author Aenaos
 */
public interface Usable extends Feature {

    public void use(Inventory inventory, Room room);
}
