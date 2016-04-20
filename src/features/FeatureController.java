/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import java.util.HashMap;
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

    public Feature getFeature(String attr, State state) throws Exception {
        Feature feature;

        HashMap<String,Feature> takis = new HashMap<>();
        
        takis.forEach((String,Feature)->System.out.println(""));
        takis.forEach((attr,feature)-> get);
        if (state.getCurrentRoom().getNearbyRooms().existsInHashMap(attr)) {
            feature = getRoomFeature(attr, state);
        }
        
        if (state.getCurrentRoom().getRoomItems().existsInHashMap(attr)) {
            feature = getItemFeature(attr, state);
        }

        if (state.getCurrentRoom().getContainerType().hasContainer() && state.getCurrentRoom()) {
            pickable.pickup(state.getActor().getInventory(), state.getCurrentRoom().getRoomItems());
        }

        if (attr.equals("inventory")) {
            feature = getInventoryFeature(state);
        }
        if (attr.equals("around")) {
            feature = state.getCurrentRoom();
        }
        if (attr.equals("chest")) {
            //  return getInventoryFeature(state);
        }
        return feature;
    }

    private Feature getRoomFeature(String attr, State state) {
        return (Feature) state.getCurrentRoom().getNearbyRooms().getElements().get(attr);
    }

    private Feature getItemFeature(String attr, State state) {
        return (Feature) state.getCurrentRoom().getRoomItems().getElements().get(attr);
    }

    private Feature getInventoryFeature(State state) {
        return (Feature) state.getActor().getInventory();
    }

    public Containable tryLambda() {
        return null;
    }
}
