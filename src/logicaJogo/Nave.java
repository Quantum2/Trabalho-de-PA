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
public class Nave implements Serializable{
    int pos_x, pos_y;
    int pos_x_ant, pos_y_ant;

    Nave() {
        pos_x = 0;
        pos_y = 0;
        pos_x_ant = 0;
        pos_y_ant = 0;
    }

    public int getPos_x() {
        return 6 - pos_x;
    }

    public void setPos_x(int pos_x) {
        pos_x_ant = this.pos_x;
        this.pos_x = pos_x;

        if (this.pos_x < 0) {
            this.pos_x = 0;
        }
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        pos_y_ant = this.pos_y;
        this.pos_y = pos_y;
        
        if (this.pos_y < 0) {
            this.pos_y = 0;
        }
    }

    public void retPosAnterior() {
        this.pos_x = pos_x_ant;
        this.pos_y = pos_y_ant;
    }
}
