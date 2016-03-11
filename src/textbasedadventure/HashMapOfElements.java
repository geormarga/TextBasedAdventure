/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Aenaos
 */
public class HashMapOfElements<T> implements Subject{
     
    private final ArrayList<Observer> observers;
    private HashMap<String, T> elements = new HashMap<>();
     
     public HashMapOfElements() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        observers.remove(deleteObserver);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public HashMap<String, T> getElements() {
        return elements;
    }

    public void setElements(HashMap<String, T> elements) {
        this.elements = elements;
    }

    public void removeElement(String text,T T) {
        this.getElements().remove(text);
        notifyObserver();
    }
    
    
    public void addElement(String name,T element) {
        this.elements.put(name, element);
        notifyObserver();
    }

    public boolean existsInHashMap(String string) {
        return elements.containsKey(string);
    }

}
