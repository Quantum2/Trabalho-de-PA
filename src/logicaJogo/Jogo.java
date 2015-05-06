/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;
import java.util.ArrayList;

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
    public ArrayList<String> stringSaida;
    ArrayList<Carta> cartasExploradas;
    public int validezDados;
    public int imprimirCheck = 0;
    public int imprimirMapaCheck = 0;

    public Mapa getMap() {
        return map;
    }

    public Nave getJogador() {
        return jogador;
    }
    
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
        imprimirMapaCheck = 1;
    }

    public void inicializarMem() {
        map = new Mapa();
        jogador = new Nave();
        dado = new Dado();
        cartasExploradas = new ArrayList<>();
        stringSaida = new ArrayList<>();
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
        if(comandoSeguinte.toString().equalsIgnoreCase("7"))
            return 0;
        return 1;
    }

    public void mostrarMenu() {
        stringSaida.add("\n(1) - Cima\n(2) - Baixo\n(3) - Direita\n(4) - Esquerda\n(5) - Informação da carta\n(6) - Gravar jogo\n(7) - Sair\n");
        imprimirCheck = 1;
    }

    public void gravarJogo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void movimento() {
        moedas--;
    }

    public void imprimirInformacao() {
        stringSaida.add("Moedas : " + moedas);
        imprimirCheck = 1;
    }

    public void infoCarta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}