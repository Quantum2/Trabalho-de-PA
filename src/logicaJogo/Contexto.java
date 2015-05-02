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
public class Contexto implements Estado{

    private Estado jogoEstado;
    Mapa map = new Mapa();
    
    public void setState(Estado estado){
        this.jogoEstado=estado;
    }
    
    public Estado getState(){
        return this.jogoEstado;
    }
    
    @Override
    public void doAction() {
        this.jogoEstado.doAction();
    }
    
}
