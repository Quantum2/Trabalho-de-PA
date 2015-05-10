/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaJogo.Estados;

import logicaJogo.Jogo;

/**
 *
 * @author a21230528
 */
public class comecarJogo implements Estado {
    
    public static final int num_moedas = 10;
    
    /**
     * Do action
     */
    @Override
    public void doAction(Jogo jogo) {
        if (jogo.jogoCarregado == 0) {
            jogo.inicializarMem();
            jogo.setMoedas(num_moedas);
        }
        jogo.imprimirInformacao();
        jogo.imprimirMapa();
    }
}
