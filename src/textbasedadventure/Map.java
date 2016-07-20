/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import java.util.HashMap;

/**
 *
 * @author Αέναος
 */
public class Map {

    private final HashMap<String, HashMap<String, String>> map;

    private String correctName;

    public String getCorrectName() {
        return correctName;
    }

    public void setCorrectName(String correctName) {
        this.correctName = correctName;
    }

    Map() {
        this.map = new HashMap<>();

        HashMap<String, String> forestNames = new HashMap<>();
        HashMap<String, String> abandonedTempleNames = new HashMap<>();
        HashMap<String, String> startingRoomNames = new HashMap<>();
        HashMap<String, String> castleNames = new HashMap<>();
        HashMap<String, String> caveNames = new HashMap<>();
        HashMap<String, String> deadEndNames = new HashMap<>();
        HashMap<String, String> dungeonNames = new HashMap<>();
        HashMap<String, String> hallNames = new HashMap<>();
        HashMap<String, String> hiddenRoomNames = new HashMap<>();
        HashMap<String, String> keepNames = new HashMap<>();
        HashMap<String, String> livingRoomNames = new HashMap<>();
        HashMap<String, String> studyNames = new HashMap<>();

        startingRoomNames.put("game", "forest");

        forestNames.put("north", "dead end");
        forestNames.put("west", "castle");
        forestNames.put("east", "keep");
        forestNames.put("key", "rusty key");
        forestNames.put("tree", "moldy tree");
        forestNames.put("sundial", "sundial");

        abandonedTempleNames.put("west", "keep");
        abandonedTempleNames.put("statue", "statue");
        abandonedTempleNames.put("altar", "altar");

        castleNames.put("east", "forest");
        castleNames.put("in", "hall");
        castleNames.put("west", "cave");
        castleNames.put("chest", "common chest");

        caveNames.put("east", "castle");
        caveNames.put("oldman", "old man");
        caveNames.put("rock", "rock");

        deadEndNames.put("south", "forest");
        deadEndNames.put("down", "dungeon");
        deadEndNames.put("hole", "hole");
        deadEndNames.put("wheel", "wooden wheel");
        deadEndNames.put("hatch", "hatch");

        dungeonNames.put("up", "hall");
        dungeonNames.put("water", "water");
        dungeonNames.put("corpse", "corpse");
        dungeonNames.put("parchment", "parchment");

        hallNames.put("out", "castle");
        hallNames.put("right", "living room");
        hallNames.put("down", "dungeon");
        hallNames.put("left", "study");
        hallNames.put("key", "rusty key");
        hallNames.put("chest", "common chest");

        hiddenRoomNames.put("out", "study");
        hiddenRoomNames.put("stand", "stand");
        hiddenRoomNames.put("artifact", "triangular artifact");

        keepNames.put("west", "forest");
        keepNames.put("east", "abandoned temple");
        keepNames.put("chest", "silver chest");
        keepNames.put("mudpit", "mudpit");
        keepNames.put("key", "silver key");

        livingRoomNames.put("left", "hall");

        studyNames.put("right", "hall");
        studyNames.put("down", "dungeon");
        studyNames.put("in", "hidden room");
        studyNames.put("book", "book");
        studyNames.put("bookshelf", "bookshelf");

        this.map.put("starting room", startingRoomNames);
        this.map.put("forest", forestNames);
        this.map.put("abandoned temple", abandonedTempleNames);
        this.map.put("castle", castleNames);
        this.map.put("cave", caveNames);
        this.map.put("dead end", deadEndNames);
        this.map.put("dungeon", dungeonNames);
        this.map.put("hall", hallNames);
        this.map.put("hidden room", hiddenRoomNames);
        this.map.put("keep", keepNames);
        this.map.put("living room", livingRoomNames);
        this.map.put("study", studyNames);
    }

    //Takes the user input as a cropped string and returns name of the room he wants to go to if adjacent to the room. Else returns !!!!!!!!nothere!!!!!!
    public void getCorrectRoomName(String room, String attr) {
        HashMap<String, String> mapData = map.get(room);
        correctName = mapData.get(attr);
    }
}
