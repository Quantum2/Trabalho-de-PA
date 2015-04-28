/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.texto;

import logicaJogo.*;

/**
 *
 * @author a21230528
 */
public class iniciaJogo {
    public static void iuEngine(){
        Contexto cont = new Contexto();
        Estado comecarJogo = new comecarJogo();
        
        cont.setState(comecarJogo);
        cont.doAction();
        Estado state = cont.getState();
    }
}
