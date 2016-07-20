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
        
        this.currentRoom = startingRoom;
        this.actor = new Actor();
        System.out.println(this.currentRoom.getDescription());

    }
}
