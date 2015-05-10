/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;
import java.util.ArrayList;
import static logicaJogo.Utils.randInt;

/**
 *
 * @author Rafael
 */
public class Mapa implements Serializable{
    Carta map[][] = new Carta[7][9];
    ArrayList<CartaPlaneta> planetas = new ArrayList<>();
    ArrayList<CartaPlanetaPirata> piratas = new ArrayList<>();
    String coords[];
    Dado dado = new Dado();
    
    public static final int num_wormholes = 2;
    public static final int num_vazios = 12;
    public static final int num_planetas = 6;
    public static final int num_planetas_piratas = 3;
  
    Mapa() {
        definirCoords();
        inicializarPlanetasDados();
        preencherAcaso();
        colocarDados();
    }

    public Carta[][] getMap() {
        return map;
    }
    
    public ArrayList<String> devolverInfo(int x, int y){
        ArrayList<String> info = new ArrayList<>();
        
        if("P".equals(map[x][y].tipo)){
            CartaPlaneta temp;
            temp = (CartaPlaneta) map[x][y];
            info.add(temp.nome);
            info.add(Integer.toString(temp.recs_amarelo));
            info.add(Integer.toString(temp.recs_azul));
            info.add(Integer.toString(temp.recs_vermelho));
            info.add(Integer.toString(temp.recs_preto));
        }
        
        if("X".equals(map[x][y].tipo)){
            CartaPlanetaPirata temp;
            temp = (CartaPlanetaPirata) map[x][y];
            info.add(temp.nome);
            info.add(Integer.toString(temp.recs_amarelo));
            info.add(Integer.toString(temp.recs_azul));
            info.add(Integer.toString(temp.recs_vermelho));
            info.add(Integer.toString(temp.recs_preto));
        }
        
        return info;
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

    /*public void imprimirMapa(Nave nave) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if(!" ".equals(map[i][j].tipo)) {
                    System.out.print("|");
                }
                else {
                    System.out.print(" ");
                }
               
                System.out.print(map[i][j].tipo);
                if (nave.getPos_x() == i && nave.getPos_y() == j) {
                    if (" ".equals(map[i][j].tipo)) {
                        nave.retPosAnterior();
                    }
                    System.out.print("*");
                }
                
                if(!" ".equals(map[i][j].tipo)) {
                    System.out.print("|");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }*/

    private void definirCoords() {
        coords = new String[]{"1,3","1,8","2,2","2,3","2,4","2,6","2,7","2,8","3,1","3,2","3,3","3,4","3,5","3,6","3,7","4,0","4,1","4,2","4,4","4,5","4,6","5,0","5,5"
        };
    }

    private void colocarDados() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j].tipo.equalsIgnoreCase("P")) {
                    map[i][j] = planetas.get(0);
                    planetas.remove(0);
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j].tipo.equalsIgnoreCase("X")) {
                    map[i][j] = piratas.get(0);
                    piratas.remove(0);
                }
            }
        }
    }

    private void inicializarPlanetasDados() {
        CartaPlaneta temp;
        CartaPlanetaPirata tempPirata;
        String nomesPlanetas[] = new String[]{"Gethen", "Kiber", "Reverie", "Tiamat", "Lamarckia", "Arrakis"};
        String nomesPiratas[] = new String[]{"Whirl", "Striterax", "Asperta"};
        int recsPlanetasAzuis[] = new int[]{1, 3, 1, 3, 2, 2};
        int recsPlanetasAmarelos[] = new int[]{3, 1, 2, 2, 3, 1};
        int recsPlanetasVermelhos[] = new int[]{2, 2, 3, 1, 1, 3};
        int recsPlanetasPretos[] = new int[]{3, 3, 3, 3, 3, 3};
        
        for(int i=0;i<num_planetas;i++){
            temp = new CartaPlaneta();
            
            temp.nome = nomesPlanetas[i];
            temp.recs_azul = recsPlanetasAzuis[i];
            temp.recs_amarelo = recsPlanetasAmarelos[i];
            temp.recs_vermelho = recsPlanetasVermelhos[i];
            temp.recs_preto = recsPlanetasPretos[i];
            
            planetas.add(temp);
        }
        
        for(int i=0;i<num_planetas_piratas;i++){
            tempPirata = new CartaPlanetaPirata();
            
            tempPirata.nome = nomesPiratas[i];
            switch (i) {
                case 0:
                    tempPirata.recs_amarelo = 3;
                case 1:
                    tempPirata.recs_vermelho = 3;
                case 2:
                    tempPirata.recs_azul = 3;
                default:
                    break;
            }
            piratas.add(tempPirata);
        }
    }

    int replenishMarket() {
        String resultado;
        int retValue = 0;
        
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if("X".equals(map[i][j].tipo)){
                    CartaPlanetaPirata temp = new CartaPlanetaPirata();
                    temp = (CartaPlanetaPirata) map[i][j];
                    
                    if (temp.disp.size() < 1) {
                        temp.disp.clear();
                        temp.disp.add("preto");
                        map[i][j] = temp;
                    }
                }
                
                if("P".equals(map[i][j].tipo)){
                    CartaPlaneta temp = new CartaPlaneta();
                    temp = (CartaPlaneta) map[i][j];
                 
                    if (temp.disp.size() < 2) {
                        temp.disp.clear();
                        resultado = dado.efectuarLancamento("Colorido");

                        if (null != resultado) {
                            switch (resultado) {
                                case "branco":
                                    retValue = 1;
                                    break;
                                case "preto":
                                    retValue = 2;
                                    break;
                                case "vermelho":
                                    temp.disp.add("vermelho");
                                    break;
                                case "amarelo":
                                    temp.disp.add("amarelo");
                                    break;
                                case "azul":
                                    temp.disp.add("azul");
                                    break;
                            }
                        }
                    }
                }
            }
        }
        return retValue;
    }
}