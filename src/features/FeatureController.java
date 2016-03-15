/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import java.util.logging.Level;
import java.util.logging.Logger;
import messages.IMessage;
import messages.game.FeatureNotFoundMessage;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class FeatureController {
    
    public boolean hasFeature(String attr, State state) {
        boolean check = false;
        if (state.getCurrentRoom().getNearbyRooms().existsInHashMap(attr)) {
            check = true;
        } else if (state.getCurrentRoom().getRoomItems().existsInHashMap(attr)) {
            check = true;
        } else if (state.getCurrentRoom().getRoomItems().existsInHashMap(attr)) {
            check = true;
        } else if (attr.equals("inventory")) {
            check = true;
        } else if (attr.equals("around")) {
            check = true;
        } else {
            IMessage message = new FeatureNotFoundMessage();
            message.display(attr);
        }
        return check;
    }

    public Feature getRoomFeature(String attr, State state) {
        return (Feature) state.getCurrentRoom().getNearbyRooms().getElements().get(attr);
    }

    public Feature getItemFeature(String attr, State state) {
        return (Feature) state.getCurrentRoom().getRoomItems().getElements().get(attr);
    }

    public Feature getInventoryFeature(State state) {
        return (Feature) state.getActor().getInventory();
    }

    public Feature getFeature(String attr, State state) throws Exception {
        if (state.getCurrentRoom().getNearbyRooms().existsInHashMap(attr)) {
            return getRoomFeature(attr, state);
        }
        if (state.getCurrentRoom().getRoomItems().existsInHashMap(attr)) {
            return getItemFeature(attr, state);
        }
        if (attr.equals("inventory")) {
            return getInventoryFeature(state);
        }
        if (attr.equals("around")) {
            return state.getCurrentRoom();
        }
        return (Feature) new Object();
    }
}
