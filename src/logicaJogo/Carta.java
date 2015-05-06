/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaJogo;

/**
 *
 * @author a21230528
 */
public class Carta {

    /**
     *Tipo de carta
     */
    public String tipo;
}

class CartaNula extends Carta {

    CartaNula() {
        tipo = " ";
    }
}

class CartaEspaçoVazio extends Carta {

    public CartaEspaçoVazio() {
        tipo = "V";
    }

}

class CartaPlaneta extends Carta {

    String nome;
    int recs_azul;
    int recs_amarelo;
    int recs_vermelho;
    int recs_preto;

    CartaPlaneta() {
        tipo = "P";
    }
}

class CartaPlanetaPirata extends CartaPlaneta {

    CartaPlanetaPirata() {
        tipo = "X";
    }
}

class CartaWormhole extends Carta {

    public CartaWormhole() {
        tipo = "W";
    }

}