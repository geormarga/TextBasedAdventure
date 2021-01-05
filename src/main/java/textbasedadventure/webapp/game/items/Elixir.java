/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.features.Usable;
import textbasedadventure.webapp.game.rooms.Room;
import textbasedadventure.webapp.game.Inventory;

/**
 * @author Aenaos
 */
@Component("elixir")
public class Elixir extends Item implements Pickable, Usable {

    public Elixir() {
        name = "elixir";
        description = "An elixir that could cure most diseases.";
        //featureFactory.registerFeature(this.name, this);
    }

    @Override
    public String pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        return "You picked up an elixir.";
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
    public String use(Inventory inventory, Room room) {
        room.registerItem(this.name);
        inventory.unregisterItem(this.name);
        //altar you already set the object
        return "Use method";
    }
}