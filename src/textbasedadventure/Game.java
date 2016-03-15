/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure;

import features.Loadable;
import features.Saveable;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.IMessage;
import messages.action.LoadFailureMessage;
import messages.action.LoadSuccessMessage;

/**
 *
 * @author Aenaos
 */
public class Game implements Saveable, Loadable {

    @Override
    public void load() {
       boolean check;
        IMessage message;
        if  (true){//lol
            message = new LoadSuccessMessage();
            /*FileInputStream readFile = null;
            try {
            readFile = new FileInputStream("as.sav");
            } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            ObjectInputStream restore = null;
            try {
            restore = new ObjectInputStream(readFile);
            } catch (IOException ex) {
            Logger.getLogger(LoadAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            State temp = null;
            try {
            temp = (State) restore.readObject();
            } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LoadAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            state.setCurrentRoom(temp.getCurrentRoom());
            state.setActor(temp.getActor());
            System.out.println(state.getCurrentRoom().getDescription());*/
            check = true;
        }else{
            message = new LoadFailureMessage();
            check = false; 
        }
        message.display("");
    }

    @Override
    public void save(State state) {
        /*
         public boolean save(State state, Saveable saveable) {
         FileOutputStream saveFile = null;
         try {
         saveFile = new FileOutputStream(file);
         } catch (FileNotFoundException ex) {
         Logger.getLogger(SaveAction.class.getName()).log(Level.SEVERE, null, ex);
         }
         try (ObjectOutputStream save = new ObjectOutputStream(saveFile)) {
         save.writeObject(state);
         } catch (IOException ex) {
         Logger.getLogger(SaveAction.class.getName()).log(Level.SEVERE, null, ex);
         }

         System.out.println("The game has been saved!");
         return true;
         }
         */
    }
}
