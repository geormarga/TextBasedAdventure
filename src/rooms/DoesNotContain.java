/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.Containable;

/**
 *
 * @author Aenaos
 */
public class DoesNotContain implements Containable {

    @Override
    public boolean contains() {
        return true;
    }

    @Override
    public boolean tryIfContains() {
        return true;
    }

}
