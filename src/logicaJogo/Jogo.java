/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaJogo;

/**
 *
 * @author a21230528
 */
public class Jogo {
    public Contexto con;
    Estado estadoActual = new comecarJogo();
    Mapa map;

    public Jogo() {
        this.con = new Contexto();
        map = new Mapa();
    }
    
    
}
