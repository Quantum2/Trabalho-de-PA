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
public class comecarJogo implements Estado {
    
    public static final int num_moedas = 30;
    
    /**
     * Do action
     */
    @Override
    public void doAction() {
        jogo.inicializarMem();
        jogo.setMoedas(num_moedas);
        jogo.imprimirInformacao();
        jogo.imprimirMapa();
    }
}
