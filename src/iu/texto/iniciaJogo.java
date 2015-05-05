/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.texto;

import java.util.Scanner;
import logicaJogo.*;
import logicaJogo.Estados.Estado;
import logicaJogo.Estados.comecarJogo;
import logicaJogo.Estados.esperaEntrada;
import logicaJogo.Estados.processaDados;

/**
 *
 * @author a21230528
 */
public class iniciaJogo {

    /**
     *
     */
    public static void iuEngine(){
        Contexto con = new Contexto();
        Estado comecarJogo = new comecarJogo();
        Estado esperaEntrada = new esperaEntrada();
        Estado processaDados = new processaDados();
        boolean acabar = false;

        con.setState(comecarJogo);
        con.doAction();
        
        do{
            con.setState(esperaEntrada);
            
            do {
                Estado.jogo.mostrarMenu();
                Scanner entrada = new Scanner(System.in);
                int s = entrada.nextInt();
                Estado.jogo.setComandoSeguinte(new StringBuffer(new Integer(s).toString()));
                
                con.doAction();
            } while (Estado.jogo.validezDados != 0);
            
            UtilsIUTexto.clearConsole();
            
            con.setState(processaDados);
            con.doAction();
        } while (acabar != true);
    }
}
