/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import features.Feature;
import features.Storable;
import java.io.File;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Aenaos
 */
public class Game implements Storable {

    private final File savegame = new File("//");
    
    @Override
    public void load() {
        
        // Create a file input stream
        FileInputStream fin;
        try {
            fin = new FileInputStream(savegame);
        } catch (FileNotFoundException ex) {
            System.err.println("No load");
        }
    }

    @Override
    public void save(State state) {
       
        FileOutputStream saveFile;
        try {
            saveFile = new FileOutputStream(savegame);
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(state);
        } catch (Exception ex) {
            System.err.println("No save");
        }
    }

    @Override
    public Feature getFeature() {
        return this;
    }
}
