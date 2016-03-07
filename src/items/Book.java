/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Pullable;

/**
 *
 * @author Aenaos
 */
public class Book extends Item implements Pullable {

    private boolean pulled = false;

    public boolean isPulled() {
        return pulled;
    }

    public void setPulled(boolean pulled) {
        this.pulled = pulled;
    }

    public Book() {
        this.setName("book");
        setDescription("There's some sort of mechanism linking this particular book to the bookshelf.");
    }

    @Override
    public void pull() {
        this.setPulled(true);
        this.setDescription("You already pulled the book");
        System.out.println("A chasm opened on the wall, you can go in");
    }
}
