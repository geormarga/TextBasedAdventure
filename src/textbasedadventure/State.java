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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class State implements Serializable {

    private Actor actor;
    private Room currentRoom;
    private Stack<Room> route = new Stack<>();
    private final FeatureFactory featureFactory = new FeatureFactory();

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

    public FeatureFactory getFeatureFactory() {
        return featureFactory;
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
        //studyRooms.put("in", hiddenRoom);
        studyItems.put("book", book);
        studyItems.put("bookshelf", bookshelf);
/*
        //Create List<String> for every room's NearbyRooms & RoomItems
       
        List<String> startingRoomRooms = new ArrayList<>();

        List<String> abandonedTempleRooms = new ArrayList<>();
        List<String> abandonedTempleItems = new ArrayList<>();

        List<String> forestRooms = new ArrayList<>();
        List<String> forestItems = new ArrayList<>();
        
        List<String> castleRooms = new ArrayList<>();
        List<String> castleItems = new ArrayList<>();

        List<String> caveRooms = new ArrayList<>();
        List<String> caveItems = new ArrayList<>();

        List<String> deadEndRooms = new ArrayList<>();
        List<String> deadEndItems = new ArrayList<>();

        List<String> dungeonRooms = new ArrayList<>();
        List<String> dungeonItems = new ArrayList<>();

        List<String> hallRooms = new ArrayList<>();
        List<String> hallItems = new ArrayList<>();

        List<String> hiddenRoomRooms = new ArrayList<>();
        List<String> hiddenRoomItems = new ArrayList<>();

        List<String> keepRooms = new ArrayList<>();
        List<String> keepItems = new ArrayList<>();

        List<String> livingRoomRooms = new ArrayList<>();

        List<String> studyRooms = new ArrayList<>();
        List<String> studyItems = new ArrayList<>();

        //Fill the List<String> with items and rooms
        startingRoomRooms.add(forest);

        abandonedTempleRooms.add(keep);
        abandonedTempleItems.add(statue);
        abandonedTempleItems.add(altar);

        forestRooms.add(deadEnd);
        forestRooms.add(castle);
        forestRooms.add(keep);

        forestItems.add(rustyKey);
        forestItems.add(moldyTree);
        forestItems.add(sundial);

        castleRooms.add(forest);
        castleRooms.add(hall);
        castleRooms.add(cave);
        castleItems.add(commonChest);

        caveRooms.add(castle);
        caveItems.add(oldMan);
        caveItems.add(rock);

        deadEndRooms.add(forest);
        deadEndRooms.add(dungeon);
        deadEndItems.add(hole);
        deadEndItems.add(woodenWheel);
        deadEndItems.add(hatch);

        dungeonRooms.add(hall);
        dungeonItems.add(water);
        dungeonItems.add(corpse);
        dungeonItems.add(parchment);

        hallRooms.add(castle);
        hallRooms.add(livingRoom);
        hallRooms.add(dungeon);
        hallRooms.add(study);
        hallItems.add(rustyKey);
        hallItems.add(commonChest);

        hiddenRoomRooms.add(study);
        hiddenRoomItems.add(stand);
        hiddenRoomItems.add(triangularArtifact);

        keepRooms.add(forest);
        keepRooms.add(abandonedTemple);
        keepItems.add(silverChest);
        keepItems.add(mudpit);
        keepItems.add(silverKey);

        livingRoomRooms.add(hall);

        studyRooms.add(hall);
        studyRooms.add(dungeon);
        //studyRooms.add(hiddenRoom);
        studyItems.add(book);
        studyItems.add(bookshelf);
*/
        
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
}
