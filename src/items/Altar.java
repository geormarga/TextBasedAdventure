/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

/**
 *
 * @author Aenaos
 */
public class Altar extends Item {

    boolean hasCircular;
    boolean hasTriangular;
    boolean hasRectangular;
    
    public Altar() {
        this.setName("altar");
        setDescription("There are three slots for different artifacts to place. \n"
                + "A circular, a rectangular and a triangular one.");
    }
    
    public boolean hasCircular() {
        return hasCircular;
    }

    public void hasCircular(boolean hasCircular) {
        this.hasCircular = hasCircular;
    }

    public boolean hasTriangular() {
        return hasTriangular;
    }

    public void setTriangular(boolean hasTriangular) {
        this.hasTriangular = hasTriangular;
    }

    public boolean hasRectangular() {
        return hasRectangular;
    }

    public void setRectangular(boolean hasRectangular) {
        this.hasRectangular = hasRectangular;
    }
}
