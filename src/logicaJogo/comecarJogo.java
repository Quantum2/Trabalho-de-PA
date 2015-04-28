/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaJogo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a21230528
 */
public class comecarJogo implements Estado{
    public static final int TAMANHO_MAPA = 30;
    
    @Override
    public void doAction() {
        List<Carta> campo = new ArrayList<>();
        
        gerarCampo(campo);
    }
    
    void gerarCampo(List<Carta> c){
        for(int i=0;i<TAMANHO_MAPA;i++){
            
        }
    }
}
