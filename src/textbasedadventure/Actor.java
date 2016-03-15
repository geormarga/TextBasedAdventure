/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import java.io.Serializable;

/**
 *
 * @author Aenaos
 */
public class Actor implements Serializable {

    private final Inventory inventory;

    public Actor() {
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
