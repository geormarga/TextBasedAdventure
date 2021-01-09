package textbasedadventure.webapp.game.rooms;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.features.Lookable;
import textbasedadventure.webapp.game.features.Moveable;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

@Component
public abstract class Room implements Lookable, Serializable, Moveable {

    protected List<String> nearbyRooms;
    protected RoomContainer roomContainer;

    protected List<String> roomActors;
    protected String name;
    protected String description;
    protected String hint;

    public void registerItem(String itemName) {
        roomContainer.registerItem(itemName);
    }

    public void unregisterItem(String itemName) {
        roomContainer.unregisterItem(itemName);
    }


    public void registerActor(String actorName) {
        roomActors.add(actorName);
    }

    public void unregisterActor(String actorName) {
        roomActors.remove(actorName);
    }

    public boolean isPresentInRoom(String actorName) {
        return roomActors.contains(actorName);
    }

    void registerRoom(String roomName) {
        nearbyRooms.add(roomName);
    }

    boolean existsInRoom(String itemName) {
        return roomContainer.isInContainer(itemName);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getMovementMessage() {
        return this.getDescription();
    }

    public RoomContainer getRoomContainer() {
        return roomContainer;
    }

    public void setRoomContainer(RoomContainer roomContainer) {
        this.roomContainer = roomContainer;
    }

    @Override
    public String look() {
        return hint;
    }

    @Override
    public String move(State state) {
        state.setPreviousRoom(state.getCurrentRoom());
        state.setCurrentRoom(this);
        return this.getMovementMessage();
    }
}
