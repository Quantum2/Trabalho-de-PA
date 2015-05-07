/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;
        
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
        iniciaJogo motor = new iniciaJogo();

        switch (opcao) {
            case 1:
                motor.iuEngine();
            case 2:
                motor.carregarJogo();
                motor.iuEngine();
            case 3:
                break;
            case 4:
                System.exit(0);
            default:
                break;
        }
    }
    
}
