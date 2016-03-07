/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class Keep extends Room implements Observer{

    public Keep() {

        setDescription("You are in the keep. Unfortunately there's no visible path from which you can enter.");
        setHint("You see something shining in a mudpit. A silver chest lies on the ground.");
    }
    
    @Override
    public void update() {
        if (!roomItems.getItems().containsKey("key")) {
            setHint("You see something shining in a mudpit.");
        }
    }
}
