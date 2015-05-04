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
    StringBuffer comandoSeguinte;
    public int validezDados;
    
    /**
     *
     * @param x
     * @param y
     */
    public void mudarPosicaoNave(int x, int y){
        
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
        map.imprimirMapa();
    }

    public void inicializarMem() {
        map = new Mapa();
        jogador = new Nave();
        dado = new Dado();
    }

    public int verificarValidadeComando() {
        if(comandoSeguinte.toString().equalsIgnoreCase("cima"))
            return 0;
        if(comandoSeguinte.toString().equalsIgnoreCase("baixo"))
            return 0;
        if(comandoSeguinte.toString().equalsIgnoreCase("direita"))
            return 0;
        if(comandoSeguinte.toString().equalsIgnoreCase("esquerda"))
            return 0;
        return 1;
    }
}
