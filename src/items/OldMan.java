/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.util.Scanner;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class OldMan extends Item {

    public String choice;

    public OldMan() {
        this.setName("old man");
        setDescription("You see an old man screaming in pain.What do you do?\n"
                + "Put him out of his misery..[press 1]\nTry to help him somehow[press 2]"
                + "\nDo nothing[press 3]");
    }

    public void examine(State state) {
        System.out.println(this.getDescription());
        OUTER:
        while (this.getDescription().equals("You see an old man screaming in pain.What do you do?\n"
                + "Put him out of his misery..[press 1]\nTry to help him somehow[press 2]"
                + "\nDo nothing[press 3]")) {
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();
            switch (choice) {
                case "1": //Create the golden key in the room
                    System.out.println("You killed the old man.");
                    this.setDescription("This is the old man's corpse.There is a key in his pocket");
                    this.createItem(state);
                    break;
                case "2": //Change the descriptions
                    this.setDescription("The old man is in a lot of pain and he is trempling.\n"
                            + "He seems to have a desease");
                    System.out.println(this.getDescription());
                    break;
                case "3":
                    break OUTER;
                default:
                    System.out.println("Please select one of the choices!");
                    this.choice = scan.nextLine();
                    break;
            }
        }
    }

    private void createItem(State state) //Create item golden key
    {

        Item goldenKey = new GoldenKey();
        state.getCurrentRoom().getRoomItems().getElements().put("key", goldenKey);

    }
}