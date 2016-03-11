/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Turnable;

/**
 *
 * @author Aenaos
 */
public class WoodenWheel extends Item implements Turnable {

    boolean turned;

    public boolean isTurned() {
        return turned;
    }

    public void setTurned(boolean turned) {
        this.turned = turned;
    }

    public WoodenWheel() {
        setName("wooden wheel");
        setDescription("You can turn it, to open the floodgate.");
    }

    @Override
    public void turn() {
        this.setTurned(true);
        this.setDescription("Already turned.");
        System.out.println("The floodgate is open.");
    }


}
