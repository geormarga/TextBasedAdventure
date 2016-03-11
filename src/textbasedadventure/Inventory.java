package textbasedadventure;

import features.Showable;
import items.Item;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aenaos
 */
public class Inventory extends HashMapOfElements<Item> implements Showable {

    @Override
    public void show() {
        for (String key : getElements().keySet()) {
            System.out.println(key);
        }
    }
}
