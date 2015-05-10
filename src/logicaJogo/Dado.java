/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;
import static logicaJogo.Utils.randInt;

/**
 *
 * @author Rafael
 */
public class Dado implements Serializable{
    private int random;
    
    Dado(){
        
    }
    
    String efectuarLancamento(String tipo) {
        random = randInt(0, 7);
        
        if (tipo.equalsIgnoreCase("Normal")) {
            return Integer.toString(random);
        } else if (tipo.equalsIgnoreCase("Colorido")) {
            switch (random){
                case 1:
                    return "vermelho";
                case 2:
                    return "azul";
                case 3:
                    return "amarelo";
                case 4:
                    return "preto";
                case 5:
                    return "branco";
                case 6:
                    return "branco";
                default:
                    break;
            }
        }
        return null;
    }
}