/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.items.containers.Inventory;

/**
 * @author Aenaos
 */
public interface Examinable extends Feature {

    String examine(Inventory inventory);
}
