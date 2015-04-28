/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaJogo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a21230528
 */
public class comecarJogo implements Estado {

    public static final int TAMANHO_MAPA_X = 30;
    public static final int TAMANHO_MAPA_Y = 30;

    private List<Carta> campo;

    /**
     * Do action
     */
    @Override
    public void doAction() {
        campo = new ArrayList<>();

        gerarCampo(campo);
    }

    void gerarCampo(List<Carta> c) {
        for (int i = 0; i < TAMANHO_MAPA_X; i++) {

        }
    }

    public List<Carta> getCampo() {

        return campo;
    }
}
