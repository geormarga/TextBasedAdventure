/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.items.containers.Inventory;
import textbasedadventure.webapp.game.items.containers.Container;

/**
 * @author Aenaos
 */
public interface Pickable extends Examinable {

    String pickup(Inventory inventory, Container container);
}
