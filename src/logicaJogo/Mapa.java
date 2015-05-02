/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

/**
 *
 * @author Rafael
 */
public class Mapa {
    Carta map[][] = new Carta[7][9];
  
    Mapa() {
        preencherAcaso();
    }

    private void preencherAcaso() {
        Carta c;
        c = new CartaNula();
        
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = c;
            }
        }
    }

    private void imprimirMapa() {
        for(int i=0;i<7;i++){
            for(int j=0;j<9;j++){
                System.out.println(map[i][j].tipo);
            }
        }
    }
}