/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import textbasedadventure.Inventory;
import textbasedadventure.RoomItems;

/**
 *
 * @author Aenaos
 */
public interface Pickable extends Examinable {
    public void pickup(Inventory inventory, RoomItems roomItems);
}
