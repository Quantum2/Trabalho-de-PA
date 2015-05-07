/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;

import logicaJogo.Carta;
import logicaJogo.Jogo;
import logicaJogo.Mapa;
import logicaJogo.Nave;

/**
 *
 * @author Rafael
 */
public class io implements Runnable {

    private Thread t;
    private final String threadName;
    boolean work = true;
    Jogo j;

    public io(String name) {
        threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            do{
                if (j.imprimirCheck == 1) {
                    System.out.print(j.stringSaida.get(0));
                    j.stringSaida.remove(0);
                    if (j.stringSaida.isEmpty()) {
                        j.imprimirCheck = 0;
                    }
                }

                if (j.imprimirMapaCheck == 1) {
                    Mapa mapa = j.getMap();
                    Nave nave = j.getJogador();

                    Carta map[][] = mapa.getMap();

                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 9; j++) {
                            if (!" ".equals(map[i][j].tipo)) {
                                System.out.print("|");
                            } else {
                                System.out.print(" ");
                            }

                            System.out.print(map[i][j].tipo);
                            if (nave.getPos_x() == i && nave.getPos_y() == j) {
                                if (" ".equals(map[i][j].tipo)) {
                                    nave.retPosAnterior();
                                }
                                System.out.print("*");
                            }

                            if (!" ".equals(map[i][j].tipo)) {
                                System.out.print("|");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    j.imprimirMapaCheck = 0;
                }
                
                Thread.sleep(50);
            }while(work);
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start(Jogo jogo) {
        if (t == null) {
            t = new Thread(this, threadName);
            j = jogo;
            t.start();
        }
    }

}