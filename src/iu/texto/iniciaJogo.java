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
        
        con.setState(comecarJogo);
        con.doAction();
    }
}
