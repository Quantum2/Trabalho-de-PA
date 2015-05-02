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
    String coords[];
    
    public static final int num_wormholes = 2;
    public static final int num_vazios = 14;
    public static final int num_planetas = 6;
    public static final int num_planetas_piratas = 3;
  
    Mapa() {
        definirCoords();
        preencherAcaso();
    }

    private void preencherAcaso() {
        Carta c;
        c = new CartaNula();
        int temp_x, temp_y, check = 0;
        StringBuffer temp = new StringBuffer();
        ArrayList<String> removidos = new ArrayList<>();
        
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = c;
            }
        }

        c = new CartaWormhole();
        map[6][0] = c;
        map[0][8] = c;

        while (check < num_wormholes) {
            temp_x = randInt(0, 6);
            temp_y = randInt(0, 8);
            temp.append(temp_x);
            temp.append(",");
            temp.append(temp_y);
            
            for (String coord : coords) {
                if(coord.contentEquals(temp) && !removidos.contains(temp.toString())){
                    check++;
                    map[temp_x][temp_y]=c;
                    removidos.add(temp.toString());
                }
            }
            
            temp.setLength(0);
        }
        
        check = 0;
        c = new CartaPlaneta();
        
        while (check < num_planetas) {
            temp_x = randInt(0, 6);
            temp_y = randInt(0, 8);
            temp.append(temp_x);
            temp.append(",");
            temp.append(temp_y);
            
            for (String coord : coords) {
                if(coord.contentEquals(temp) && !removidos.contains(temp.toString())){
                    check++;
                    map[temp_x][temp_y]=c;
                    removidos.add(temp.toString());
                }
            }
            
            temp.setLength(0);
        }
        
        check = 0;
        c = new CartaPlanetaPirata();
        
        while (check < num_planetas_piratas) {
            temp_x = randInt(0, 6);
            temp_y = randInt(0, 8);
            temp.append(temp_x);
            temp.append(",");
            temp.append(temp_y);
            
            for (String coord : coords) {
                if(coord.contentEquals(temp) && !removidos.contains(temp.toString())){
                    check++;
                    map[temp_x][temp_y]=c;
                    removidos.add(temp.toString());
                }
            }
            
            temp.setLength(0);
        }
        
        check = 0;
        c = new CartaEspaçoVazio();
        
        while (check < num_vazios) {
            temp_x = randInt(0, 6);
            temp_y = randInt(0, 8);
            temp.append(temp_x);
            temp.append(",");
            temp.append(temp_y);
            
            for (String coord : coords) {
                if(coord.contentEquals(temp) && !removidos.contains(temp.toString())){
                    check++;
                    map[temp_x][temp_y]=c;
                    removidos.add(temp.toString());
                }
            }
            
            temp.setLength(0);
        }
    }

    public void imprimirMapa() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if(map[i][j].tipo!=" ")
                    System.out.print("|");
                else
                    System.out.print(" ");
                
                System.out.print(map[i][j].tipo);
                
                if(map[i][j].tipo!=" ")
                    System.out.print("|");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void definirCoords() {
        coords = new String[]{"0,8","1,3","1,8","2,2","2,3","2,4","2,6","2,7","2,8","3,1","3,2","3,3","3,4","3,5","3,6","3,7","4,0","4,1","4,2","4,4","4,5","4,6","5,0","5,5","6,0"
        };
    }
}