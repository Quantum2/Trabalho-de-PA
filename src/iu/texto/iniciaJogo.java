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
import logicaJogo.Estados.verificacaoDados;

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
            jogo.jogoCarregado = 1;
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
        Estado verificacaoDados = new verificacaoDados();
        boolean acabar = false;
        
        io t1 = new io("Thread 1");
        input t2 = new input("Thread 2");
        t1.start(jogo);
        t2.start(jogo);

        con.setState(comecarJogo);
        con.doAction(jogo);
        
        do{
            con.setState(esperaEntrada);
            
            do {
                jogo.mostrarMenuTexto();
                Scanner entrada = new Scanner(System.in);
                int s = entrada.nextInt();
                jogo.setComandoSeguinte(new StringBuffer(Integer.toString(s)));
                
                con.doAction(jogo);
                UtilsIUTexto.clearConsole();
            } while (jogo.validezDados != 0);
            
            con.setState(processaDados);
            con.doAction(jogo);
            
            con.setState(verificacaoDados);
            con.doAction(jogo);
        } while (acabar != true);
    }
}
