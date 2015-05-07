/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iu.texto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    
    Jogo jogo = new Jogo();

    public  void carregarJogo(){
        try {
            FileInputStream fileIn = new FileInputStream("jogo");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            jogo = (Jogo) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    /**
     *
     */
    public void iuEngine(){
        Contexto con = new Contexto();
        Estado comecarJogo = new comecarJogo();
        Estado esperaEntrada = new esperaEntrada();
        Estado processaDados = new processaDados();
        boolean acabar = false;
        
        io t1 = new io("Thread 1");
        t1.start(jogo);

        con.setState(comecarJogo);
        con.doAction(jogo);
        
        do{
            con.setState(esperaEntrada);
            
            do {
                jogo.mostrarMenu();
                Scanner entrada = new Scanner(System.in);
                int s = entrada.nextInt();
                jogo.setComandoSeguinte(new StringBuffer(Integer.toString(s)));
                
                con.doAction(jogo);
            } while (jogo.validezDados != 0);
            
            UtilsIUTexto.clearConsole();
            
            con.setState(processaDados);
            con.doAction(jogo);
        } while (acabar != true);
    }
}
