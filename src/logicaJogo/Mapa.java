/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.util.ArrayList;
import static logicaJogo.Utils.randInt;

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
        int temp_x, temp_y, check = 0;

        ArrayList<Integer> rand_x = new ArrayList<>();
        ArrayList<Integer> rand_y = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = c;
            }
        }

        c = new CartaWormhole();
        map[6][0] = c;
        map[0][8] = c;

        while (check < 2) {
            temp_x = randInt(0, 7);
            temp_y = randInt(0, 9);
            if (rand_x.contains(temp_x)) {
                if(rand_y.contains(temp_y)){
                    map[temp_x][temp_y]=c;
                    rand_x.remove(temp_x);
                    rand_y.remove(temp_y);
                    check++;
                }
            }
        }
    }

    public void imprimirMapa() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if(map[i][j].tipo!=" ")
                    System.out.print("|");
                
                System.out.print(map[i][j].tipo);
                
                if(map[i][j].tipo!=" ")
                    System.out.print("|");
            }
            System.out.println();
        }
    }
}