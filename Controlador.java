/*
 *Controlador principal
 */
package juegoletras_controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Timer;
/**
 *
 * @author Luly
 */
public class Controlador implements ActionListener, KeyListener{
    private Vista vista;
    private Timer tiempo;
    private char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    
    /**
     * 
     * @param velocidad : velocidad de caída de las letras según el nivel
     */
    public void actualizar(int velocidad){
        //tiempo = new javax.swing.Timer(velocidad, this);       
        //tiempo(generarLetra(),velocidad);
        //tiempo.start();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }
    /**
     * 
     * @param ke : elemento del teclado que ha sido pulsado
     * 
     * este método diferencia entre si se pulsa un boton de direccion, en cuyo caso
     * el ladrillo se mueve en dicha direccion y si se pulsa una letra
     * se elimina de la pantalla
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                //moverLadrillo("up");
                break;
            case KeyEvent.VK_DOWN:
                //moverLadrillo("down");
                break;
            case KeyEvent.VK_LEFT:
                //moverLadrillo("left");
                break;
            case KeyEvent.VK_RIGHT:
                //moverLadrillo("rigth");
                break;
            default:
                //si no es una posicion, compruebo que sea una letra
                for (int i = 0; i < letras.length; i++) {
                    //si el char es una letra (un char válido)
                    if(ke.getKeyChar()==letras[i]){
                     //   modelo.borrarLetra(vista.borrarLetra);
                    }               
                }
                
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
}
