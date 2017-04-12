package textbasedadventure;

import features.FeatureFactory;
import features.Showable;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aenaos
 */
public class Inventory implements Showable {

   

    private String name;
    private List<String> items = new ArrayList<>();

    public Inventory(FeatureFactory featureFactory) {
        this.name = "inventory";
        featureFactory.registerFeature(this.name,this);

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
    public void show() {
        items.forEach(System.out::println);
    }

}
