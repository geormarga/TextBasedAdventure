package textbasedadventure.webapp.game.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.features.Feature;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.items.Item;
import textbasedadventure.webapp.game.items.containers.Chest;
import textbasedadventure.webapp.game.items.containers.Container;

@Component("pick up")
public class PickUpAction implements Action {

    @Override
    public String execute(State state, List<Feature> pickables) {
        Pickable pickable = (Pickable) pickables.get(0);
        Item item = (Item) pickables.get(0);
        Container container = getContainers(state).stream().filter(cont -> cont.isInContainer(item.getName())).findFirst().get();
        return pickable.pickup(state.getInventory(), container);
    }

    @Override
    public boolean isEligibleForAction(State state, List<Feature> pickables) {
        Pickable pickable = (Pickable) pickables.get(0);
        List<Container> containerList = getContainers(state);
        Item item = (Item) pickable;
        return containerList.stream().anyMatch(container -> container.isInContainer(item.getName()));
    }

    private boolean hasChest(State state) {
        try {
            getChests(state);
            return true;
        } catch (NullPointerException ex) {
            return false;
        }
    }

    private List<String> getChests(State state) {
        List<String> chestNames = Arrays.asList("silver chest", "golden chest", "common chest");
        return chestNames.stream().filter(chest -> state.getCurrentRoom().getRoomContainer().isInContainer(chest)).collect(Collectors.toList());
    }

    private List<Container> getContainers(State state) {
        List<Container> containerList = new ArrayList<>();
        containerList.add(state.getCurrentRoom().getRoomContainer());
        if (hasChest(state)) {
            List<Container> chests = getChests(state)
                    .stream()
                    .filter(chestName -> state.getFeatureFactory().getFeature(chestName) != null)
                    .map(chestName -> (Chest) state.getFeatureFactory().getFeature(chestName))
                    .filter(Chest::isUnlocked)
                    .collect(Collectors.toList());
            chests.forEach(chest -> containerList.add(chest));
        }
        return containerList;
    }
}
