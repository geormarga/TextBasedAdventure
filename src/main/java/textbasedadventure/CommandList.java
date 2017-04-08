package textbasedadventure;

import java.util.*;

public class CommandList {

    private HashMap<String, List<String>> commandList;

    public CommandList() {
        initCommandList();
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
    public boolean areValidAttributes(List<String> attributes) {
        List<String> attrList = new LinkedList<>();
        this.commandList.values().forEach(value -> attrList.addAll(value));
        return attrList.containsAll(attributes) && !attributes.isEmpty();
    }

    private void initCommandList() {
        this.commandList = new HashMap<>();

        //Commands
        commandList.put("go", Arrays.asList("east", "west", "south", "north", "in", "out", "left", "right", "straight", "back", "down", "up"));
        commandList.put("pickup", Arrays.asList("key", "note", "torch", "sundial", "artifact", "elixir", "piece"));
        commandList.put("open", Arrays.asList("door", "chest", "hatch"));
        commandList.put("start", Arrays.asList("game"));
        commandList.put("load", Arrays.asList("game"));
        commandList.put("look", Arrays.asList("around"));
        commandList.put("show", Arrays.asList("inventory"));
        //commandList.put("game", Arrays.asList("exit", "start", "load", "save"));
        commandList.put("use", Arrays.asList("rustykey", "silverkey", "goldenkey", "torch", "elixir"));
        commandList.put("turn", Arrays.asList("wheel"));
        commandList.put("pull", Arrays.asList("book"));
        commandList.put("examine", Arrays.asList("key", "torch", "tree", "sundial", "hole", "chest", "note", "plainnote", "tornnote", "mudpit", "corpse", "water", "wheel", "hatch", "parchment", "statue", "altar", "bookshelf", "book", "stand", "artifact", "circularartifact", "triangularartifact", "rectangularartifact", "rock", "oldman", "elixir", "rustykey", "silverkey", "goldenkey"));
    }


}
