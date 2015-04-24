/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;
import java.util.Scanner;
import java.lang.String;

/**
 *
 * @author Rafael
 */
public class welcomeMsg {
    public static void imprimirTextoInicial(){
        utils.clearConsole();
        
        System.out.println("-------------------");
        System.out.println(" Milky Way Express");
        System.out.println("-------------------");
        
        System.out.println("\n1 - Opção não implementada");
        System.out.println("\n2 - Opção não implementada");
        System.out.println("\n3 - Opção não implementada");
        System.out.println("\n4 - Sair\n");
    }
    
    public static int getOpcao(){
        Scanner entrada = new Scanner(System.in);
        String s = entrada.nextLine();
        
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            System.out.println("Não inseriu um opção válida");
        }
        
        return Integer.parseInt(s);
    }
}
