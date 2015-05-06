/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;

import logicaJogo.Carta;
import logicaJogo.Estados.Estado;
import logicaJogo.Mapa;
import logicaJogo.Nave;

/**
 *
 * @author Rafael
 */
public class io implements Runnable {

    private Thread t;
    private String threadName;
    boolean work = true;

    public io(String name) {
        threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            do{
                if (Estado.jogo.imprimirCheck == 1) {
                    System.out.print(Estado.jogo.stringSaida.get(0));
                    Estado.jogo.stringSaida.remove(0);
                    if (Estado.jogo.stringSaida.isEmpty()) {
                        Estado.jogo.imprimirCheck = 0;
                    }
                }

                if (Estado.jogo.imprimirMapaCheck == 1) {
                    Mapa mapa = Estado.jogo.getMap();
                    Nave nave = Estado.jogo.getJogador();

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
                    Estado.jogo.imprimirMapaCheck = 0;
                }
                
                Thread.sleep(50);
            }while(work);
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

}