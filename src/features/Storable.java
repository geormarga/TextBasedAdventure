/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public interface Storable extends Feature{
    public void save(State state);
    public void load();
}