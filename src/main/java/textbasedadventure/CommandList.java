package textbasedadventure;

import java.util.*;

class CommandList {

    private HashMap<String, List<String>> commandList;

    CommandList() {
        initCommandList();
    }

    private HashMap<String, List<String>> getCommandList() {
        return this.commandList;
    }

    boolean isVerb(String command) {
        return this.getCommandList().containsKey(command);
    }

    /*
    * Validates user input attributes
    */
    boolean areValidAttributes(List<String> attributes) {
        List<String> attrList = new LinkedList<>();
        this.commandList.values().forEach(attrList::addAll);
        return attrList.containsAll(attributes) && !attributes.isEmpty();
    }

    private void initCommandList() {
        this.commandList = new HashMap<>();

        //Commands
        commandList.put("go", Arrays.asList("east", "west", "south", "north", "in", "out", "left", "right", "straight", "back", "down", "up"));
        commandList.put("pickup", Arrays.asList("key", "note", "torch", "sundial", "artifact", "elixir", "piece"));
        commandList.put("open", Arrays.asList("door", "chest", "hatch"));
        commandList.put("start", Collections.singletonList("game"));
        commandList.put("load", Collections.singletonList("game"));
        commandList.put("look", Collections.singletonList("around"));
        commandList.put("show", Collections.singletonList("inventory"));
        commandList.put("start", Collections.singletonList("game"));
        //commandList.put("game", Arrays.asList("exit", "start", "load", "save"));
        commandList.put("use", Arrays.asList("rustykey", "silverkey", "goldenkey", "torch", "elixir"));
        commandList.put("turn", Collections.singletonList("wheel"));
        commandList.put("pull", Collections.singletonList("book"));
        commandList.put("examine", Arrays.asList("key", "torch", "tree", "sundial", "hole", "chest", "note", "plainnote", "tornnote", "mudpit", "corpse", "water", "wheel", "hatch", "parchment", "statue", "altar", "bookshelf", "book", "stand", "artifact", "circularartifact", "triangularartifact", "rectangularartifact", "rock", "oldman", "elixir", "rustykey", "silverkey", "goldenkey"));
    }


}
