package textbasedadventure;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandList {

    private final HashMap<String, ArrayList<String>> commandList;

    public CommandList() {
        this.commandList = new HashMap<>();
        
        ArrayList attrMove = new ArrayList();
        ArrayList attrPickup = new ArrayList();
        ArrayList attrOpen = new ArrayList();
        ArrayList attrShow = new ArrayList();
        ArrayList game = new ArrayList();
        ArrayList attrExamine = new ArrayList();
        ArrayList attrLookAround = new ArrayList();
        ArrayList attrGame = new ArrayList();
        ArrayList attrUse = new ArrayList();
        ArrayList attrTurn = new ArrayList();
        ArrayList attrPull = new ArrayList();

        attrMove.add("east");
        attrMove.add("west");
        attrMove.add("south");
        attrMove.add("north");
        attrMove.add("in");
        attrMove.add("out");
        attrMove.add("left");
        attrMove.add("right");
        attrMove.add("straight");
        attrMove.add("back");
        attrMove.add("down");
        attrMove.add("up");

        attrPickup.add("key");
        attrPickup.add("note");
        attrPickup.add("torch");
        attrPickup.add("sundial");
        attrPickup.add("artifact");
        attrPickup.add("elixir");
        attrPickup.add("piece");

        attrOpen.add("door");
        attrOpen.add("chest");
        attrOpen.add("hatch");

        attrShow.add("inventory");

        attrLookAround.add("around");

        attrTurn.add("wheel");

        attrPull.add("book");

        game.add("game");

        attrExamine.add("key");
        attrExamine.add("torch");
        attrExamine.add("tree");
        attrExamine.add("sundial");
        attrExamine.add("hole");
        attrExamine.add("chest");
        attrExamine.add("note");
        attrExamine.add("plainnote");
        attrExamine.add("tornnote");
        attrExamine.add("mudpit");
        attrExamine.add("corpse");
        attrExamine.add("water");
        attrExamine.add("wheel");
        attrExamine.add("hatch");
        attrExamine.add("parchment");
        attrExamine.add("statue");
        attrExamine.add("altar");
        attrExamine.add("bookshelf");
        attrExamine.add("book");
        attrExamine.add("stand");
        attrExamine.add("artifact");
        attrExamine.add("circularartifact");
        attrExamine.add("triangularartifact");
        attrExamine.add("rectangularartifact");
        attrExamine.add("rock");
        attrExamine.add("oldman");
        attrExamine.add("elixir");
        attrExamine.add("rustykey");
        attrExamine.add("silverkey");
        attrExamine.add("goldenkey");

        attrUse.add("rustykey");
        attrUse.add("silverkey");
        attrUse.add("goldenkey");
        attrUse.add("torch");
        attrUse.add("elixir");

        attrGame.add("exit");
        attrGame.add("start");
        attrGame.add("load");
        attrGame.add("save");

        commandList.put("go", attrMove);
        commandList.put("pickup", attrPickup);
        commandList.put("open", attrOpen);
        commandList.put("exit", game);
        commandList.put("start", game);
        commandList.put("examine", attrExamine);
        commandList.put("save", game);
        commandList.put("load", game);
        commandList.put("look", attrLookAround);
        commandList.put("show", attrShow);
        commandList.put("game", attrGame);
        commandList.put("use", attrUse);
        commandList.put("turn", attrTurn);
        commandList.put("pull", attrPull);
    }

    public HashMap<String, ArrayList<String>> getCommandList() {
        return this.commandList;
    }

    public boolean isVerb(String command) {
        return this.getCommandList().containsKey(command);
    }

    public boolean isAttr(String command, String attr) {
        
        ArrayList<String> setMap = this.getCommandList().get(command);
        if(setMap==null){
            return false;
        }else{
            return setMap.contains(attr);
        }
     
    }
}
