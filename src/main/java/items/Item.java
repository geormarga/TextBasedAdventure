/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Examinable;

import java.io.Serializable;

/**
 * @author Aenaos
 */
public abstract class Item implements Examinable, Serializable {

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
