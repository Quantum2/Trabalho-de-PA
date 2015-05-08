/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicaJogo.Jogo;

/**
 *
 * @author Rafael
 */
public class input implements Runnable{
    
    private Thread t;
    private final String threadName;
    boolean work = true;
    Jogo j;

    public input(String name) {
        threadName = name;
    }
    
    @Override
    public void run() {
        System.out.println("Running " + threadName);
       
        do {
            try {
                if (j.needsMoreInput == 1) {
                    Scanner entrada = new Scanner(System.in);
                    int s = entrada.nextInt();
                    j.stringEntrada.add(Integer.toString(s));
                    j.needsMoreInput = 0;
                }
                
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(input.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (work);
    }
    
    public void start(Jogo jogo) {
        if (t == null) {
            t = new Thread(this, threadName);
            j = jogo;
            t.start();
        }
    }
}