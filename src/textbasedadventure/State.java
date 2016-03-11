/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import features.Feature;
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
import java.util.HashMap;
import java.util.Stack;
import messages.IMessage;
import messages.game.FeatureNotFoundMessage;

public class State implements Serializable {

    private Actor actor;
    private Room currentRoom;
    private Stack<Room> route = new Stack<>();

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Stack getRoute() {
        return route;
    }

    public void setRoute(Stack route) {
        this.route = route;
    }

    public State() {
        this.initState();
    }

    private void initState() {

        //Create Rooms
        Room forest = new Forest();
        Room castle = new Castle();
        Room keep = new Keep();
        Room deadEnd = new DeadEnd();
        Room startingRoom = new StartingRoom();
        Room hall = new Hall();
        Room livingRoom = new LivingRoom();
        Room cave = new Cave();
        Room dungeon = new Dungeon();
        Room abandonedTemple = new AbandonedTemple();
        Room hiddenRoom = new HiddenRoom();
        Room study = new Study();

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

        //Create HashMaps for every room's NearbyRooms & RoomItems
        HashMap<String, Room> startingRoomRooms = new HashMap<>();

        HashMap<String, Room> abandonedTempleRooms = new HashMap<>();
        HashMap<String, Item> abandonedTempleItems = new HashMap<>();

        HashMap<String, Room> forestRooms = new HashMap<>();
        HashMap<String, Item> forestItems = new HashMap<>();

        HashMap<String, Room> castleRooms = new HashMap<>();
        HashMap<String, Item> castleItems = new HashMap<>();

        HashMap<String, Room> caveRooms = new HashMap<>();
        HashMap<String, Item> caveItems = new HashMap<>();

        HashMap<String, Room> deadEndRooms = new HashMap<>();
        HashMap<String, Item> deadEndItems = new HashMap<>();

        HashMap<String, Room> dungeonRooms = new HashMap<>();
        HashMap<String, Item> dungeonItems = new HashMap<>();

        HashMap<String, Room> hallRooms = new HashMap<>();
        HashMap<String, Item> hallItems = new HashMap<>();

        HashMap<String, Room> hiddenRoomRooms = new HashMap<>();
        HashMap<String, Item> hiddenRoomItems = new HashMap<>();

        HashMap<String, Room> keepRooms = new HashMap<>();
        HashMap<String, Item> keepItems = new HashMap<>();

        HashMap<String, Room> livingRoomRooms = new HashMap<>();

        HashMap<String, Room> studyRooms = new HashMap<>();
        HashMap<String, Item> studyItems = new HashMap<>();

        //Fill the HashMaps with items and rooms
        startingRoomRooms.put("game", forest);

        abandonedTempleRooms.put("west", keep);
        abandonedTempleItems.put("statue", statue);
        abandonedTempleItems.put("altar", altar);

        forestRooms.put("north", deadEnd);
        forestRooms.put("west", castle);
        forestRooms.put("east", keep);

        forestItems.put("key", rustyKey);
        forestItems.put("tree", moldyTree);
        forestItems.put("sundial", sundial);

        castleRooms.put("east", forest);
        castleRooms.put("in", hall);
        castleRooms.put("west", cave);
        castleItems.put("chest", commonChest);

        caveRooms.put("east", castle);
        caveItems.put("oldman", oldMan);
        caveItems.put("rock", rock);

        deadEndRooms.put("south", forest);
        deadEndRooms.put("down", dungeon);
        deadEndItems.put("hole", hole);
        deadEndItems.put("wheel", woodenWheel);
        deadEndItems.put("hatch", hatch);

        dungeonRooms.put("up", hall);
        dungeonItems.put("water", water);
        dungeonItems.put("corpse", corpse);
        dungeonItems.put("parchment", parchment);

        hallRooms.put("out", castle);
        hallRooms.put("right", livingRoom);
        hallRooms.put("down", dungeon);
        hallRooms.put("left", study);
        hallItems.put("key", rustyKey);
        hallItems.put("chest", commonChest);

        hiddenRoomRooms.put("out", study);
        hiddenRoomItems.put("stand", stand);
        hiddenRoomItems.put("artifact", triangularArtifact);

        keepRooms.put("west", forest);
        keepRooms.put("east", abandonedTemple);
        keepItems.put("chest", silverChest);
        keepItems.put("mudpit", mudpit);
        keepItems.put("key", silverKey);

        livingRoomRooms.put("left", hall);

        studyRooms.put("right", hall);
        studyRooms.put("down", dungeon);
        // studyRooms.put("in", hiddenRoom);
        studyItems.put("book", book);
        studyItems.put("bookshelf", bookshelf);

        //Assign HashMaps to objects
        forest.setNearbyRooms(forestRooms);
        forest.setRoomItems(forestItems);

        startingRoom.setNearbyRooms(startingRoomRooms);

        castle.setNearbyRooms(castleRooms);
        castle.setRoomItems(castleItems);

        keep.setNearbyRooms(keepRooms);
        keep.setRoomItems(keepItems);

        deadEnd.setNearbyRooms(deadEndRooms);
        deadEnd.setRoomItems(deadEndItems);

        hall.setNearbyRooms(hallRooms);
        hall.setRoomItems(hallItems);

        livingRoom.setNearbyRooms(livingRoomRooms);

        cave.setNearbyRooms(caveRooms);
        cave.setRoomItems(caveItems);

        dungeon.setNearbyRooms(dungeonRooms);
        dungeon.setRoomItems(dungeonItems);

        abandonedTemple.setNearbyRooms(abandonedTempleRooms);
        abandonedTemple.setRoomItems(abandonedTempleItems);

        hiddenRoom.setNearbyRooms(hiddenRoomRooms);
        hiddenRoom.setRoomItems(hiddenRoomItems);

        study.setNearbyRooms(studyRooms);
        study.setRoomItems(studyItems);

        this.currentRoom = startingRoom;
        this.actor = new Actor();
        System.out.println(this.currentRoom.getDescription());

    }

    public Feature getRoomFeature(String attr) {
        return (Feature) this.getCurrentRoom().getNearbyRooms().getElements().get(attr);
    }

    public Feature getItemFeature(String attr) {
        return (Feature) this.getCurrentRoom().getRoomItems().getElements().get(attr);
    }

    public Feature getInventoryFeature() {
        return (Feature) this.getActor().getInventory();
    }

    public Feature getFeature(String attr) throws Exception {

        if (this.getCurrentRoom().getNearbyRooms().existsInHashMap(attr)) {
            return getRoomFeature(attr);
        }
        if (this.getCurrentRoom().getRoomItems().existsInHashMap(attr)) {
            return getItemFeature(attr);
        }
        if (attr.equals("inventory")) {
            return getInventoryFeature();
        }
        if (attr.equals("around")) {
            return this.getCurrentRoom();
        }

        return (Feature) new Object();
    }

    public boolean hasFeature(String attr) {
        boolean check = false;
        if (this.getCurrentRoom().getNearbyRooms().existsInHashMap(attr)) {
            check = true;
        } else if (this.getCurrentRoom().getRoomItems().existsInHashMap(attr)) {
            check = true;
        } else if (this.getCurrentRoom().getRoomItems().existsInHashMap(attr)) {
            check = true;// how to get items in containers
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

}
