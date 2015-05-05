/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaJogo.Estados;

/**
 *
 * @author a21230528
 */
public class processaDados implements Estado{

    @Override
    public void doAction() {
        int x=0, y=0;
        
        if(jogo.getComandoSeguinte().toString().equalsIgnoreCase("1")) {
            x=1;
        }
        if(jogo.getComandoSeguinte().toString().equalsIgnoreCase("3")) {
            y=1;
        }
        if(jogo.getComandoSeguinte().toString().equalsIgnoreCase("4")) {
            y=-1;
        }
        if(jogo.getComandoSeguinte().toString().equalsIgnoreCase("2")) {
            x=-1;
        }
            
        jogo.mudarPosicaoNave(x, y);
        jogo.imprimirMapa();
    }
    
}
