package textbasedadventure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Aenaos on 1/4/2017.
 */
public class Map {

        private HashMap<String, HashMap<String, String>> map;
        private HashMap<String, List<String>> commandList;
        private HashMap<String, String> attrList;

        public Map() {
            initAttrList();
            initMap();
        }

        public HashMap<String, List<String>> getCommandList() {
            return this.commandList;
        }

        public boolean isVerb(String command) {
            return this.getCommandList().containsKey(command);
        }


        /*
        * Validates user input attributes
        */
        public boolean areValidAttributes(List<String> attributes, State state) {

            attributes.forEach(attr -> prepareAttrList(attr, state));
            List<Boolean> areValidAttr = new ArrayList<>();
            //check if all of the attributes are valid against a
            attributes.forEach(attr -> areValidAttr.add(attrList.containsKey(attr)));
            return !areValidAttr.contains(false);
        }


        public boolean isAttribute(String attr, State state) {
            this.prepareAttrList(attr, state);
            return attrList.containsKey(attr);
        }

        public String getCorrectAttribute(String attr) {
            return this.attrList.get(attr);
        }

        private void prepareAttrList(String attr, State state) {
            switch (attr) {
                case "back": {
                    this.attrList.put("back", state.getPreviousRoom().getName());
                }
                case "west": {
                    HashMap<String, String> mapData = this.map.get(state.getCurrentRoom().getName());
                    this.attrList.put("west", mapData.get("west"));
                    break;
                }
                case "east": {
                    HashMap<String, String> mapData = this.map.get(state.getCurrentRoom().getName());
                    this.attrList.put("east", mapData.get("east"));
                    break;
                }
                case "south": {
                    HashMap<String, String> mapData = this.map.get(state.getCurrentRoom().getName());
                    this.attrList.put("south", mapData.get("south"));
                    break;
                }
                case "north": {
                    HashMap<String, String> mapData = this.map.get(state.getCurrentRoom().getName());
                    this.attrList.put("north", mapData.get("north"));
                    break;
                }
                case "in": {
                    HashMap<String, String> mapData = this.map.get(state.getCurrentRoom().getName());
                    this.attrList.put("in", mapData.get("in"));
                    break;
                }
                case "out": {
                    HashMap<String, String> mapData = this.map.get(state.getCurrentRoom().getName());
                    this.attrList.put("out", mapData.get("out"));
                    break;
                }
                case "right": {
                    HashMap<String, String> mapData = this.map.get(state.getCurrentRoom().getName());
                    this.attrList.put("right", mapData.get("right"));
                    break;
                }
                case "left": {
                    HashMap<String, String> mapData = this.map.get(state.getCurrentRoom().getName());
                    this.attrList.put("left", mapData.get("left"));
                    break;
                }
                case "down": {
                    HashMap<String, String> mapData = this.map.get(state.getCurrentRoom().getName());
                    this.attrList.put("down", mapData.get("down"));
                    break;
                }
                case "around": {
                    this.attrList.put("around", state.getCurrentRoom().getName());
                    break;
                }
                default: {
                    break;
                }
            }
        }

        private void initMap() {
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

            forestNames.put("north", "dead end");
            forestNames.put("west", "castle");
            forestNames.put("east", "keep");

            abandonedTempleNames.put("west", "keep");

            castleNames.put("east", "forest");
            castleNames.put("in", "hall");
            castleNames.put("west", "cave");

            caveNames.put("east", "castle");

            deadEndNames.put("south", "forest");
            deadEndNames.put("down", "dungeon");

            dungeonNames.put("up", "hall");

            hallNames.put("out", "castle");
            hallNames.put("right", "living room");
            hallNames.put("down", "dungeon");
            hallNames.put("left", "study");

            hiddenRoomNames.put("out", "study");

            keepNames.put("west", "forest");
            keepNames.put("east", "abandoned temple");

            livingRoomNames.put("left", "hall");

            startingRoomNames.put("game", "forest");

            studyNames.put("right", "hall");
            studyNames.put("down", "dungeon");
            studyNames.put("in", "hidden room");

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

        private void initAttrList() {
            this.attrList = new HashMap<>();
            attrList.put("altar", "altar");
            attrList.put("book", "book");
            attrList.put("bookshelf", "bookshelf");
            attrList.put("circularartifact", "circular artifact");
            attrList.put("circular artifact", "circular artifact");
            //attrList.put("artifact","circular artifact");
            attrList.put("rectangularartifact", "rectangular artifact");
            attrList.put("rectangular artifact", "rectangular artifact");
            //attrList.put("artifact","rectangular artifact");
            attrList.put("triangularartifact", "triangular artifact");
            attrList.put("triangular artifact", "triangular artifact");
            //attrList.put("artifact","triangular artifact");
            attrList.put("corpse", "corpse");
            attrList.put("dead", "corpse");
            attrList.put("body", "corpse");
            attrList.put("elixir", "elixir");
            attrList.put("potion", "elixir");
            attrList.put("goldenkey", "golden key");
            attrList.put("golden key", "golden key");
            //attrList.put("key","golden key");
            attrList.put("hatch", "hatch");
            attrList.put("door", "hatch");
            attrList.put("old man", "old man");
            attrList.put("oldMan", "old man");
            attrList.put("man", "old man");
            attrList.put("parchment", "parchment");
            //attrList.put("note", "parchment");
            //attrList.put("paper", "parchment");
            //attrList.put("note", "plain note");
            //attrList.put("paper", "plain note");
            attrList.put("plain note", "plain note");
            attrList.put("tornNote", "torn note");
            //attrList.put("note", "torn note");
            //attrList.put("paper", "torn note");
            attrList.put("rock", "rock");
            attrList.put("key", "rusty key");
            attrList.put("rustykey", "rusty key");
            attrList.put("rusty key", "rusty key");
            attrList.put("stand", "stand");
            attrList.put("statue", "statue");
            attrList.put("sundial", "sundial");
            attrList.put("sun dial", "sundial");
            attrList.put("torch", "torch");
            attrList.put("light", "torch");
            attrList.put("fire", "torch");
            attrList.put("water", "water");
            attrList.put("woodenwheel", "wooden wheel");
            attrList.put("wooden wheel", "wooden wheel");
            attrList.put("wheel", "wooden wheel");
            attrList.put("commonchest", "common chest");
            attrList.put("common chest", "common chest");
            attrList.put("silverchest", "common chest");
            attrList.put("silver chest", "silver chest");
            attrList.put("goldenchest", "golden chest");
            attrList.put("golden chest", "golden chest");
            attrList.put("hole", "hole");
            attrList.put("tree", "moldy tree");
            attrList.put("moldy tree", "moldy tree");
            attrList.put("moldytree", "moldy tree");
            //Rooms
            attrList.put("game", "forest");

        /*
         attrList.put("down", "dungeon");
         attrList.put("up", "hall");
         attrList.put("south", "forest");
         attrList.put("north", "dead end");

         attrList.put("west", "cave");
         attrList.put("west", "keep");
         attrList.put("west", "castle");
         attrList.put("west", "cave");
         attrList.put("west", "forest");

         attrList.put("east", "keep");
         attrList.put("east", "forest");
         attrList.put("east", "abandoned temple");
         attrList.put("east", "castle");

         attrList.put("in", "hall");
         attrList.put("in", "hidden room");

         attrList.put("out", "study");
         attrList.put("out", "castle");

         attrList.put("right", "hall");
         attrList.put("right", "living room");

         attrList.put("left", "study");
         attrList.put("left", "hall");
         */
            //Inventory
            attrList.put("inventory","inventory");
            attrList.put("items","inventory");

        }
    }
