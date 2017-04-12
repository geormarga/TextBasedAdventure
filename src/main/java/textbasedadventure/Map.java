package textbasedadventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {

    private HashMap<String, HashMap<String, String>> map;
    private HashMap<String, List<String>> commandList;
    private HashMap<String, String> attrList;

    public Map() {
        initAttrList();
    }

    private HashMap<String, List<String>> getCommandList() {
        return this.commandList;
    }

    public boolean isVerb(String command) {
        return this.getCommandList().containsKey(command);
    }


    /*
    * Validates user input attributes
    */
    public boolean areValidAttributes(List<String> attributes, State state) {

        List<Boolean> areValidAttr = new ArrayList<>();
        //check if all of the attributes are valid against a
        attributes.forEach(attr -> areValidAttr.add(attrList.containsKey(attr)));
        return !areValidAttr.contains(false);
    }


    public boolean isAttribute(String attr, State state) {
        return attrList.containsKey(attr);
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

        //Inventory
        attrList.put("inventory", "inventory");
        attrList.put("items", "inventory");

    }
}
