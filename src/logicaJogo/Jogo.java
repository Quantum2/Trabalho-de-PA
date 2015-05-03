/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

/**
 *
 * @author Rafael
 */
public class Jogo {

    Mapa map;
    int moedas;
    Nave jogador;
    Dado dado;

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public Jogo() {

    }

    public void imprimirMapa() {
        map.imprimirMapa();
    }

    public void inicializarMem() {
        map = new Mapa();
        jogador = new Nave();
        dado = new Dado();
    }
}
