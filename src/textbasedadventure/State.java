/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import features.FeatureFactory;
import items.Altar;
import items.Book;
import items.Bookshelf;
import items.CircularArtifact;
import items.Corpse;
import items.Elixir;
import items.GoldenKey;
import items.Hatch;
import items.Item;
import items.OldMan;
import items.Parchment;
import items.RectangularArtifact;
import items.Rock;
import items.RustyKey;
import items.SilverKey;

import items.containers.MoldyTree;
import items.containers.CommonChest;
import items.containers.GoldenChest;
import items.containers.Hole;
import items.containers.Mudpit;
import items.containers.SilverChest;

import items.Stand;
import items.Statue;
import items.Sundial;
import items.TriangularArtifact;
import items.Water;
import items.WoodenWheel;
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
        this.initState();
    }

    private void initState() {

        //Create Rooms
        Room forest = new Forest();
        forest.setNearbyRooms(new LinkedList<>(Arrays.asList("dead end", "castle", "keep")));
        forest.setRoomItems(new LinkedList<>(Arrays.asList("rusty key", "moldy tree", "sundial")));

        Room abandonedTemple = new AbandonedTemple();
        abandonedTemple.setNearbyRooms(new LinkedList<>(Arrays.asList("keep")));
        abandonedTemple.setRoomItems(new LinkedList<>(Arrays.asList("statue", "altar")));

        Room castle = new Castle();
        castle.setNearbyRooms(new LinkedList<>(Arrays.asList("forest", "hall", "cave")));
        castle.setRoomItems(new LinkedList<>(Arrays.asList("common chest")));

        Room cave = new Cave();
        cave.setNearbyRooms(new LinkedList<>(Arrays.asList("castle")));
        cave.setRoomItems(new LinkedList<>(Arrays.asList("old man", "rock")));

        Room deadEnd = new DeadEnd();
        deadEnd.setNearbyRooms(new LinkedList<>(Arrays.asList("forest", "dungeon")));
        deadEnd.setRoomItems(new LinkedList<>(Arrays.asList("hole", "wooden wheel", "hatch")));

        Room dungeon = new Dungeon();
        dungeon.setNearbyRooms(new LinkedList<>(Arrays.asList("hall")));
        dungeon.setRoomItems(new LinkedList<>(Arrays.asList("water", "corpse", "parchment")));

        Room hall = new Hall();
        hall.setNearbyRooms(new LinkedList<>(Arrays.asList("castle", "living room", "dungeon", "study")));
        hall.setRoomItems(new LinkedList<>(Arrays.asList("common chest", "rusty key")));

        Room hiddenRoom = new HiddenRoom();
        hiddenRoom.setNearbyRooms(new LinkedList<>(Arrays.asList("study")));
        hiddenRoom.setRoomItems(new LinkedList<>(Arrays.asList("stand", "triangular artifact")));

        Room keep = new Keep();
        keep.setNearbyRooms(new LinkedList<>(Arrays.asList("forest", "abandoned temple")));
        keep.setRoomItems(new LinkedList<>(Arrays.asList("silver chest", "mudpit", "silver key")));

        Room livingRoom = new LivingRoom();
        livingRoom.setNearbyRooms(new LinkedList<>(Arrays.asList("hall")));
        livingRoom.setRoomItems(new LinkedList<>(Arrays.asList()));

        Room startingRoom = new StartingRoom();
        startingRoom.setNearbyRooms(new LinkedList<>(Arrays.asList("forest")));
        startingRoom.setRoomItems(new LinkedList<>(Arrays.asList()));

        Room study = new Study();
        study.setNearbyRooms(new LinkedList<>(Arrays.asList("hall", "dungeon", "hidden room")));
        study.setRoomItems(new LinkedList<>(Arrays.asList("book", "bookshelf")));

        //Create Items
        Item rustyKey = new RustyKey();
        Item silverChest = new SilverChest();
        Item commonChest = new CommonChest();
        Item moldyTree = new MoldyTree();
        Item hole = new Hole();
        Item mudpit = new Mudpit();
        Item woodenWheel = new WoodenWheel();
        Item hatch = new Hatch();
        Item water = new Water();
        Item corpse = new Corpse();
        Item parchment = new Parchment();
        Item statue = new Statue();
        Item altar = new Altar();
        Item stand = new Stand();
        Item book = new Book();
        Item bookshelf = new Bookshelf();
        Item goldenKey = new GoldenKey();
        Item goldenChest = new GoldenChest();
        Item oldMan = new OldMan();
        Item rock = new Rock();
        Item elixir = new Elixir();
        Item sundial = new Sundial();
        Item triangularArtifact = new TriangularArtifact();
        Item circularArtifact = new CircularArtifact();
        Item rectangularArtifact = new RectangularArtifact();
        Item silverKey = new SilverKey();

        //Create Inventory
        Inventory inventory = new Inventory();

        //Initialize FeatureFactory
        //Rooms
        featureFactory.registerFeature(forest.getName(), forest);
        featureFactory.registerFeature(castle.getName(), castle);
        featureFactory.registerFeature(keep.getName(), keep);
        featureFactory.registerFeature(deadEnd.getName(), deadEnd);
        featureFactory.registerFeature(startingRoom.getName(), startingRoom);
        featureFactory.registerFeature(hall.getName(), hall);
        featureFactory.registerFeature(livingRoom.getName(), livingRoom);
        featureFactory.registerFeature(cave.getName(), cave);
        featureFactory.registerFeature(dungeon.getName(), dungeon);
        featureFactory.registerFeature(abandonedTemple.getName(), abandonedTemple);
        featureFactory.registerFeature(hiddenRoom.getName(), hiddenRoom);
        featureFactory.registerFeature(study.getName(), study);

        //Items
        featureFactory.registerFeature(rustyKey.getName(), rustyKey);
        featureFactory.registerFeature(silverChest.getName(), silverChest);
        featureFactory.registerFeature(commonChest.getName(), commonChest);
        featureFactory.registerFeature(moldyTree.getName(), moldyTree);
        featureFactory.registerFeature(hole.getName(), hole);
        featureFactory.registerFeature(mudpit.getName(), mudpit);
        featureFactory.registerFeature(woodenWheel.getName(), woodenWheel);
        featureFactory.registerFeature(hatch.getName(), hatch);
        featureFactory.registerFeature(water.getName(), water);
        featureFactory.registerFeature(corpse.getName(), corpse);
        featureFactory.registerFeature(parchment.getName(), parchment);
        featureFactory.registerFeature(statue.getName(), statue);
        featureFactory.registerFeature(altar.getName(), altar);
        featureFactory.registerFeature(stand.getName(), stand);
        featureFactory.registerFeature(book.getName(), book);
        featureFactory.registerFeature(bookshelf.getName(), bookshelf);
        featureFactory.registerFeature(goldenKey.getName(), goldenKey);
        featureFactory.registerFeature(goldenChest.getName(), goldenChest);
        featureFactory.registerFeature(oldMan.getName(), oldMan);
        featureFactory.registerFeature(rock.getName(), rock);
        featureFactory.registerFeature(elixir.getName(), elixir);
        featureFactory.registerFeature(sundial.getName(), sundial);
        featureFactory.registerFeature(triangularArtifact.getName(), triangularArtifact);
        featureFactory.registerFeature(circularArtifact.getName(), circularArtifact);
        featureFactory.registerFeature(rectangularArtifact.getName(), rectangularArtifact);
        featureFactory.registerFeature(silverKey.getName(), silverKey);

        //Inventory
        featureFactory.registerFeature(inventory.getName(), inventory);

        this.currentRoom = startingRoom;
        this.previousRoom = startingRoom;
        this.inventory = inventory;
        System.out.println(this.currentRoom.getDescription());
    }
}
