package textbasedadventure.webapp.game.actors;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.features.Examinable;

/**
 * @author Aenaos
 */
@Component
public abstract class Actor implements Examinable, Serializable {

    protected String name;
    protected String description;

    @Override
    public String examine() {
        return description;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
