/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.FeatureFactory;
import features.Pullable;

/**
 * @author Aenaos
 */
public class Book extends Item implements Pullable {

    private boolean pulled = false;

    public Book(FeatureFactory featureFactory) {
        name = "book";
        description = "There's some sort of mechanism linking this particular book to the bookshelf.";
        featureFactory.registerFeature(this.name, this);
    }

    public boolean isPulled() {
        return pulled;
    }

    private void setPulled(boolean pulled) {
        this.pulled = pulled;
    }

    @Override
    public void pull() {
        this.setPulled(true);
        this.setDescription("You already pulled the book");
        System.out.println("A chasm opened on the wall, you can go in");
    }
}
