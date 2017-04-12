/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import features.FeatureFactory;
import items.*;

import items.containers.MoldyTree;
import items.containers.CommonChest;
import items.containers.GoldenChest;
import items.containers.Hole;
import items.containers.Mudpit;
import items.containers.SilverChest;

import rooms.AbandonedTemple;
import rooms.Castle;
import rooms.Cave;
import rooms.DeadEnd;
import rooms.Dungeon;
import rooms.Forest;
import rooms.Hall;
import rooms.HiddenRoom;
import rooms.Keep;
import rooms.LivingRoom;
import rooms.Room;
import rooms.StartingRoom;
import rooms.Study;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;

public class State implements Serializable {

    private Room currentRoom;
    private Room previousRoom;
    private Inventory inventory;

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

    public State() {

        //Create Rooms
        Room forest = new Forest(this.featureFactory);
        forest.setNearbyRooms(new LinkedList<>(Arrays.asList("dead end", "castle", "keep")));
        forest.setRoomItems(new LinkedList<>(Arrays.asList("rusty key", "moldy tree", "sundial")));

        Room abandonedTemple = new AbandonedTemple(this.featureFactory);
        abandonedTemple.setNearbyRooms(new LinkedList<>(Arrays.asList("keep")));
        abandonedTemple.setRoomItems(new LinkedList<>(Arrays.asList("statue", "altar")));

        Room castle = new Castle(this.featureFactory);
        castle.setNearbyRooms(new LinkedList<>(Arrays.asList("forest", "hall", "cave")));
        castle.setRoomItems(new LinkedList<>(Arrays.asList("common chest")));

        Room cave = new Cave(this.featureFactory);
        cave.setNearbyRooms(new LinkedList<>(Arrays.asList("castle")));
        cave.setRoomItems(new LinkedList<>(Arrays.asList("old man", "rock")));

        Room deadEnd = new DeadEnd(this.featureFactory);
        deadEnd.setNearbyRooms(new LinkedList<>(Arrays.asList("forest", "dungeon")));
        deadEnd.setRoomItems(new LinkedList<>(Arrays.asList("hole", "wooden wheel", "hatch")));

        Room dungeon = new Dungeon(this.featureFactory);
        dungeon.setNearbyRooms(new LinkedList<>(Arrays.asList("hall")));
        dungeon.setRoomItems(new LinkedList<>(Arrays.asList("water", "corpse", "parchment")));

        Room hall = new Hall(this.featureFactory);
        hall.setNearbyRooms(new LinkedList<>(Arrays.asList("castle", "living room", "dungeon", "study")));
        hall.setRoomItems(new LinkedList<>(Arrays.asList("common chest", "rusty key")));

        Room hiddenRoom = new HiddenRoom(this.featureFactory);
        hiddenRoom.setNearbyRooms(new LinkedList<>(Arrays.asList("study")));
        hiddenRoom.setRoomItems(new LinkedList<>(Arrays.asList("stand", "triangular artifact")));

        Room keep = new Keep(this.featureFactory);
        keep.setNearbyRooms(new LinkedList<>(Arrays.asList("forest", "abandoned temple")));
        keep.setRoomItems(new LinkedList<>(Arrays.asList("silver chest", "mudpit", "silver key")));

        Room livingRoom = new LivingRoom(this.featureFactory);
        livingRoom.setNearbyRooms(new LinkedList<>(Arrays.asList("hall")));
        livingRoom.setRoomItems(new LinkedList<>(Arrays.asList()));

        Room startingRoom = new StartingRoom(this.featureFactory);
        startingRoom.setNearbyRooms(new LinkedList<>(Arrays.asList("forest")));
        startingRoom.setRoomItems(new LinkedList<>(Arrays.asList()));

        Room study = new Study(this.featureFactory);
        study.setNearbyRooms(new LinkedList<>(Arrays.asList("hall", "dungeon", "hidden room")));
        study.setRoomItems(new LinkedList<>(Arrays.asList("book", "bookshelf")));

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

        this.currentRoom = startingRoom;
        this.previousRoom = startingRoom;
        this.inventory = new Inventory(this.featureFactory);
        System.out.println(this.currentRoom.getDescription());
    }
}
