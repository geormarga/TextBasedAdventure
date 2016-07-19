/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

/**
 *
 * @author Aenaos
 */
public class MoveCommand extends Command{

    public MoveCommand(){
        name = "move";
    }
    
    @Override
    boolean hasAttribute(String attr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
