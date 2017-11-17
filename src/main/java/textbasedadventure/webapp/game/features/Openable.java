/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.Inventory;

/**
 * @author Aenaos
 */
public interface Openable extends Feature {

    String open(Inventory inventory);
}
