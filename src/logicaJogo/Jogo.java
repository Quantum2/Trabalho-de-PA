/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public ArrayList<String> stringEntrada;
    ArrayList<Carta> cartasExploradas;
    public int validezDados;
    public int imprimirCheck = 0;
    public int imprimirMapaCheck = 0;
    public int jogoCarregado = 0;
    public int perdeuCheck = 0;
    public int needsMoreInput = 0;

    public Mapa getMap() {
        return map;
    }

    public Nave getJogador() {
        return jogador;
    }
    
    public void gravarJogo(){
        try {
            FileOutputStream fileOut = new FileOutputStream("jogo");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        stringEntrada = new ArrayList<>();
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
            return 2;
        if(comandoSeguinte.toString().equalsIgnoreCase("6"))
            return 0;
        if(comandoSeguinte.toString().equalsIgnoreCase("7"))
            return 0;
        return 1;
    }

    public void mostrarMenuTexto() {
        stringSaida.add("\n(1) - Cima\n(2) - Baixo\n(3) - Direita\n(4) - Esquerda\n(5) - Informação da carta\n(6) - Gravar jogo\n(7) - Sair\n");
        imprimirCheck = 1;
    }

    public void movimento() {
        moedas--;
    }

    public void imprimirInformacao() {
        stringSaida.add("Moedas : " + moedas + "\n");
        imprimirCheck = 1;
    }

    public void infoCartaTexto() throws InterruptedException {
        int recsAzul, recsVermelho, recsAmarelo, recsBranco, recsPreto;
        int pos_x = jogador.pos_x;
        int pos_y = jogador.pos_y;
        
        if("P".equals(map.map[pos_x][pos_y].tipo) || "X".equals(map.map[pos_x][pos_y].tipo)){
            stringSaida.add("\nPosição actual:\n");
            stringSaida.add(String.format("%s\n", map.devolverInfo(6 - pos_x, pos_y).get(0)));
            stringSaida.add(String.format("Recursos amarelos: %s\n", map.devolverInfo(6 - pos_x, pos_y).get(1)));
            stringSaida.add(String.format("Recursos azuis :%s\n", map.devolverInfo(6 - pos_x, pos_y).get(2)));
            stringSaida.add(String.format("Recursos vermelho :%s\n", map.devolverInfo(6 - pos_x, pos_y).get(3)));
            stringSaida.add(String.format("Recursos preto :%s\n", map.devolverInfo(6 - pos_x, pos_y).get(4)));
            imprimirCheck = 1;
        }
        
        if (pos_x + 1 < 7) {
            if ("P".equals(map.map[pos_x + 1][pos_y].tipo) || "X".equals(map.map[pos_x + 1][pos_y].tipo)) {
                stringSaida.add("\nPosição abaixo:\n");
                stringSaida.add(String.format("%s\n", map.devolverInfo(6 - pos_x + 1, pos_y).get(0)));
                stringSaida.add(String.format("Recursos amarelos: %s\n", map.devolverInfo(6 - pos_x + 1, pos_y).get(1)));
                stringSaida.add(String.format("Recursos azuis :%s\n", map.devolverInfo(6 - pos_x + 1, pos_y).get(2)));
                stringSaida.add(String.format("Recursos vermelho :%s\n", map.devolverInfo(6 - pos_x + 1, pos_y).get(3)));
                stringSaida.add(String.format("Recursos preto :%s\n", map.devolverInfo(6 - pos_x + 1, pos_y).get(4)));
                imprimirCheck = 1;
            }
        }
        
        if (pos_y + 1 < 9) {
            if ("P".equals(map.map[pos_x][pos_y + 1].tipo) || "X".equals(map.map[pos_x][pos_y + 1].tipo)) {
                stringSaida.add("\nPosição à direita:\n");
                stringSaida.add(String.format("%s\n", map.devolverInfo(6 - pos_x, pos_y + 1).get(0)));
                stringSaida.add(String.format("Recursos amarelos: %s\n", map.devolverInfo(6 - pos_x, pos_y + 1).get(1)));
                stringSaida.add(String.format("Recursos azuis :%s\n", map.devolverInfo(6 - pos_x, pos_y + 1).get(2)));
                stringSaida.add(String.format("Recursos vermelho :%s\n", map.devolverInfo(6 - pos_x, pos_y + 1).get(3)));
                stringSaida.add(String.format("Recursos preto :%s\n", map.devolverInfo(6 - pos_x, pos_y + 1).get(4)));
                imprimirCheck = 1;
            }
        }
        
        if (pos_x - 1 >= 0) {
            if ("P".equals(map.map[pos_x - 1][pos_y].tipo) || "X".equals(map.map[pos_x - 1][pos_y].tipo)) {
                stringSaida.add("\nPosição acima:\n");
                stringSaida.add(String.format("%s\n", map.devolverInfo(6 - pos_x - 1, pos_y).get(0)));
                stringSaida.add(String.format("Recursos amarelos: %s\n", map.devolverInfo(6 - pos_x - 1, pos_y).get(1)));
                stringSaida.add(String.format("Recursos azuis :%s\n", map.devolverInfo(6 - pos_x - 1, pos_y).get(2)));
                stringSaida.add(String.format("Recursos vermelho :%s\n", map.devolverInfo(6 - pos_x - 1, pos_y).get(3)));
                stringSaida.add(String.format("Recursos preto :%s\n", map.devolverInfo(6 - pos_x - 1, pos_y).get(4)));
                imprimirCheck = 1;
            }
        }
        
        if (pos_y - 1 >= 0) {
            if ("P".equals(map.map[pos_x][pos_y - 1].tipo) || "X".equals(map.map[pos_x][pos_y - 1].tipo)) {
                stringSaida.add("\nPosição à esquerda:\n");
                stringSaida.add(String.format("%s\n", map.devolverInfo(6 - pos_x, pos_y - 1).get(0)));
                stringSaida.add(String.format("Recursos amarelos: %s\n", map.devolverInfo(6 - pos_x, pos_y - 1).get(1)));
                stringSaida.add(String.format("Recursos azuis :%s\n", map.devolverInfo(6 - pos_x, pos_y - 1).get(2)));
                stringSaida.add(String.format("Recursos vermelho :%s\n", map.devolverInfo(6 - pos_x, pos_y - 1).get(3)));
                stringSaida.add(String.format("Recursos preto :%s\n", map.devolverInfo(6 - pos_x, pos_y - 1).get(4)));
                imprimirCheck = 1;
            }
        }
        
        opcaoVendaCompra();
    }

    public void mercado() {
        int perda;
        String resultado;
        perda = map.replenishMarket();
        
        switch(perda){
            case 1:
                if (jogador.recs_preto > 0) {
                    moedas = moedas - (4 * jogador.recs_preto);
                }
                break;
            case 2:
                ataquePirata();
                break;
            default:
                break;
        }
        
        if(jogador.recs_preto != 0){
            for (int i = 0; i < 2; i++) {
                resultado = dado.efectuarLancamento("Colorido");

                switch (resultado) {
                    case "branco":
                        moedas = moedas - (4 * jogador.recs_preto);
                        break;
                    case "preto":
                        ataquePirata();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void opcaoVendaCompra() throws InterruptedException {
        int pos_x = jogador.pos_x;
        int pos_y = jogador.pos_y;
        
        stringSaida.add("\n(1) - Comprar vermelho\n(2) - Comprar amarelo\n(3) - Comprar azul\n(4) - Comprar ilegal\n(5) - Comprar upgrade para nave\n");
        imprimirCheck = 1;
        
        needsMoreInput = 1;
        while(needsMoreInput == 1){
            Thread.sleep(20);
        }
        
        switch(stringEntrada.get(0)){
            case "1":
                
                break;
            case "2":
                
                break;
            case "3":
                
                break;
            default:
                break;
        }
    }

    private void ataquePirata() {
        int forcaPirata = Integer.parseInt(dado.efectuarLancamento("Normal"));
        
        stringSaida.add("ATAQUE PIRATA EM PROGRESSO !!!\n");
        imprimirCheck = 1;
        
        if (forcaPirata <= jogador.forcaBatalha) {
            stringSaida.add("Ataque de piratas derrotado !\n");
            imprimirCheck = 1;
        } else {
            moedas = moedas - (forcaPirata - jogador.forcaBatalha);
            stringSaida.add("Os piratas venceram...\n");
            imprimirCheck = 1;
        }
    }
}