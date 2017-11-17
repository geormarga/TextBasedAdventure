package textbasedadventure.webapp.game;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Showable;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Aenaos
 */
@Component("inventory")
public class Inventory implements Showable {


    private String name;
    private List<String> items = new ArrayList<>();

    public Inventory() {
        name = "inventory";
        //featureFactory.registerFeature(name, this);
    }

    public boolean isInInventory(String item) {
        return items.contains(item);
    }

    public void registerItem(String itemName) {
        items.add(itemName);
    }

    public void unregisterItem(String itemName) {
        items.remove(itemName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String show() {
        String string = "";
        items.forEach(item -> string.concat(" ,"+item));
        return string;
    }

}
