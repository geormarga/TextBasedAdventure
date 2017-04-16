/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import features.FeatureFactory;
import items.*;
import items.containers.*;
import rooms.*;

import java.io.Serializable;

public class State implements Serializable {

    private Room currentRoom;
    private Room previousRoom;
    private Inventory inventory;
    private ReadXMLFile readXMLFile = new ReadXMLFile();

    private final FeatureFactory featureFactory = new FeatureFactory();

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public FeatureFactory getFeatureFactory() {
        return featureFactory;
    }

    public ReadXMLFile getReadXMLFile() {
        return this.readXMLFile;
    }

    public State() {

        //Create Rooms
        new Forest(this.featureFactory, this.readXMLFile);
        new AbandonedTemple(this.featureFactory, this.readXMLFile);
        new Castle(this.featureFactory, this.readXMLFile);
        new Cave(this.featureFactory, this.readXMLFile);
        new DeadEnd(this.featureFactory, this.readXMLFile);
        new Dungeon(this.featureFactory, this.readXMLFile);
        new Hall(this.featureFactory, this.readXMLFile);
        new HiddenRoom(this.featureFactory, this.readXMLFile);
        new Keep(this.featureFactory, this.readXMLFile);
        new LivingRoom(this.featureFactory, this.readXMLFile);
        new Study(this.featureFactory, this.readXMLFile);
        Room startingRoom = new StartingRoom(this.featureFactory, this.readXMLFile);

        //Create Items
        new RustyKey(this.featureFactory);
        new SilverChest(this.featureFactory);
        new CommonChest(this.featureFactory);
        new MoldyTree(this.featureFactory);
        new Hole(this.featureFactory);
        new Mudpit(this.featureFactory);
        new WoodenWheel(this.featureFactory);
        new Hatch(this.featureFactory);
        new Water(this.featureFactory);
        new Corpse(this.featureFactory);
        new Parchment(this.featureFactory);
        new Statue(this.featureFactory);
        new Altar(this.featureFactory);
        new Stand(this.featureFactory);
        new Book(this.featureFactory);
        new Bookshelf(this.featureFactory);
        new GoldenKey(this.featureFactory);
        new GoldenChest(this.featureFactory);
        new OldMan(this.featureFactory);
        new Rock(this.featureFactory);
        new Elixir(this.featureFactory);
        new Sundial(this.featureFactory);
        new TriangularArtifact(this.featureFactory);
        new CircularArtifact(this.featureFactory);
        new RectangularArtifact(this.featureFactory);
        new SilverKey(this.featureFactory);
        new Torch(this.featureFactory);

        this.currentRoom = startingRoom;
        this.previousRoom = startingRoom;
        this.inventory = new Inventory(this.featureFactory);
        System.out.println(this.currentRoom.getDescription());
    }
}
