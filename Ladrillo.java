/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegointefaces;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Marta
 */
public class Ladrillo {
    private int posX;

    public Ladrillo() {
    }
    public void moverDerecha(){
        posX+=5;
    }
    public void moverIzquierda(){
        posX-=5;
    }
}
