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

    String tipo;
}

class CartaNula extends Carta {

    CartaNula() {
        tipo=" ";
    }
}

class CartaPlaneta extends Carta {

    CartaPlaneta() {
        tipo = "P";
    }
}

class CartaWormhole extends Carta {

    public CartaWormhole() {
        tipo = "W";
    }

}
