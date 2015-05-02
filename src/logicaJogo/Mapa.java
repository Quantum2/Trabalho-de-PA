/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class Mapa {
    ArrayList<Carta> elementos_x;
    ArrayList<Carta> elementos_y;
    
    Mapa(){
        elementos_x = new ArrayList<>();
        elementos_y = new ArrayList<>();
        
        Carta c;
        c = new CartaNula();

        for (int i = 0; i < 7; i++) {
            elementos_x.add(c);
        }
        
        for (int i=0;i<9;i++){
            elementos_y.add(c);
        }
        
        preencherAcaso();
    }

    private void preencherAcaso() {
        
    }
}
