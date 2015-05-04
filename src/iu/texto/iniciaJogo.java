/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.texto;

import logicaJogo.Estados.Estado;
import logicaJogo.Estados.esperaEntrada;
import logicaJogo.Estados.comecarJogo;
import logicaJogo.*;
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
        
        Estado.jogo.modo="texto";
        
        do{
            con.setState(comecarJogo);
            con.doAction();

            con.setState(esperaEntrada);
            con.doAction();
            
            con.setState(processaDados);
            con.doAction();
        } while (acabar != true);
    }
}
