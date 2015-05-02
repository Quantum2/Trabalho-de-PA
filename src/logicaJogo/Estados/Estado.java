/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaJogo.Estados;

import logicaJogo.Jogo;

/**
 * @author a21230528
 */
public interface Estado{
    Jogo jogo = new Jogo();
    
    public void doAction();
}