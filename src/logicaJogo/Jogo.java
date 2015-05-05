/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;

/**
 *
 * @author Rafael
 */
public class Jogo implements Serializable{

    Mapa map;
    int moedas;
    Nave jogador;
    Dado dado;
    StringBuffer comandoSeguinte;
    public int validezDados;
    
    /**
     *
     * @param x
     * @param y
     */
    public void mudarPosicaoNave(int x, int y){
        jogador.setPos_x(jogador.pos_x + x);
        jogador.setPos_y(jogador.pos_y + y);
    }

    public StringBuffer getComandoSeguinte() {
        return comandoSeguinte;
    }

    public void setComandoSeguinte(StringBuffer comandoSeguinte) {
        this.comandoSeguinte = comandoSeguinte;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public Jogo() {

    }

    public void imprimirMapa() {
        map.imprimirMapa(jogador);
    }

    public void inicializarMem() {
        map = new Mapa();
        jogador = new Nave();
        dado = new Dado();
    }

    public int verificarValidadeComando() {
        if(comandoSeguinte.toString().equalsIgnoreCase("1"))
            return 0;
        if(comandoSeguinte.toString().equalsIgnoreCase("2"))
            return 0;
        if(comandoSeguinte.toString().equalsIgnoreCase("3"))
            return 0;
        if(comandoSeguinte.toString().equalsIgnoreCase("4"))
            return 0;
        if(comandoSeguinte.toString().equalsIgnoreCase("5"))
            return 0;
        if(comandoSeguinte.toString().equalsIgnoreCase("6"))
            return 0;
        return 1;
    }

    public void mostrarMenu() {
        System.out.println("\n(1) - Cima\n(2) - Baixo\n(3) - Direita\n(4) - Esquerda\n(5) - Gravar jogo\n(6) - Sair");
    }

    public void gravarJogo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}