/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaJogo;

import java.util.ArrayList;
import logicaJogo.Recursos.Amarelo;
import logicaJogo.Recursos.Azul;
import logicaJogo.Recursos.Preto;
import logicaJogo.Recursos.Vermelho;

/**
 *
 * @author a21230528
 */
public class Carta {

    String tipo;
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
    ArrayList<Azul> recs_azul;
    ArrayList<Amarelo> recs_amarelo;
    ArrayList<Vermelho> recs_vermelho;
    ArrayList<Preto> recs_preto;

    CartaPlaneta() {
        recs_azul = new ArrayList<>();
        recs_amarelo = new ArrayList<>();
        recs_vermelho = new ArrayList<>();
        recs_preto = new ArrayList<>();
        tipo = "P";
    }
}

class CartaPlanetaPirata extends Carta {

    CartaPlanetaPirata() {
        tipo = "X";
    }
}

class CartaWormhole extends Carta {

    public CartaWormhole() {
        tipo = "W";
    }

}
