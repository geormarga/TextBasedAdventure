/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.List;

/**
 *
 * @author Aenaos
 */
public abstract class Command {
    
    String name;
    List<String> attributes;

    abstract boolean hasAttribute(String attr);
}
