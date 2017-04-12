/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.FeatureFactory;
import features.Pickable;
import features.Usable;
import rooms.Room;
import textbasedadventure.Inventory;

/**
 * @author Aenaos
 */
public class Elixir extends Item implements Pickable, Usable {

    public Elixir(FeatureFactory featureFactory) {
        name = "elixir";
        description = "An elixir that could cure most diseases.";
        featureFactory.registerFeature(this.name, this);
    }

    @Override
    public void pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        System.out.println("You picked up an elixir.");
    }

    /*

     public void use(String attr, State state) {
     String toUseChoice;
     Scanner scan = new Scanner(System.in);
     System.out.println("Which item you want to use the elixir on?");
     toUseChoice = scan.nextLine().toLowerCase();
     if (!state.isInRoom(toUseChoice)) {
     System.out.println("You cant use elixir that item,"
     + " or does not exist in this room");
     } else {
     OldMan oldman = (OldMan) state.getCurrentRoom().getItems().get("oldman");
     oldman.setDescription("You saved my life!");
     System.out.println("You used your elixir to save old's man life! "
     + "Thank you, to return you the favor I'll give you this golden key!");
     state.getActor().getInventory().remove(attr);
     Pickable goldenkey = new GoldenKey();
     state.addItemToActor("goldenkey", goldenkey);
     }

     }
     */
    @Override
    public void use(Inventory inventory, Room room) {
        room.registerItem(this.name);
        inventory.unregisterItem(this.name);
        //altar you already set the object
    }
}
