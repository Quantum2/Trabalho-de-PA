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
        Jogo jogo = new Jogo();
        Estado comecarJogo = new comecarJogo();
        
        jogo.con.setState(comecarJogo);
        jogo.con.doAction();
    }
}
