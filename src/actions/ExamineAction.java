/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import features.Examinable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class ExamineAction implements Action<Examinable> {

    @Override
    public boolean execute(State state, Examinable examinable) {
        examinable.examine();
        return true;
    }
}
