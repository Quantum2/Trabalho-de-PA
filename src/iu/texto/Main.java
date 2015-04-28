/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;
import static iu.texto.iniciaJogo.iuEngine;
        
/**
 *
 * @author Rafael
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcao;

        UtilsIUTexto.clearConsole();
        welcomeMsg.imprimirTextoInicial();
        opcao = welcomeMsg.getOpcao();

        switch (opcao) {
            case 1:
                iuEngine();
                break;
            default:
                break;
        }
    }
    
}
