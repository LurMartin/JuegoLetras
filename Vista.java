/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej12_applluvialetras;

import java.awt.Button;
import java.awt.CheckboxGroup;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Label;
import static java.awt.Label.LEFT;
import static java.awt.Label.RIGHT;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Lourdes
 */
public class Vista extends Frame {

    private Controlador c;
    private ControladorMenu cMenu;
    private Modelo modelo;
    //private ArrayList<Button> arrayBtn;
    private Button [] arrayBtn;
    private MenuBar barraMenu;
    private Menu mArchivo, mLevel;
    private MenuItem miSalir, miGuardar, miCargar;
    //private CheckboxGroup niveles;
    private CheckboxMenuItem[] chbmiLevel;
    private MenuShortcut mscLevel;
    private int anchoVentana, altoVentana, anchoBoton, posXLadrillo, cont=0;
    private Panel pnFondo,pnLineaFin,pnLadrillo;
    private Label nivel, puntuacion;
    private Timer timer,timer2;

    public Vista() {
        modelo=new Modelo();
        c = new Controlador(this,modelo);
        cMenu = new ControladorMenu(this,modelo);
        anchoVentana = 1000;
        altoVentana = 700;
        anchoBoton = 30;
        posXLadrillo=300;
        //arrayBtn = new ArrayList<Button>();
        arrayBtn=new Button[20];
        
        this.setLayout(null);
        this.setBounds(10, 10, anchoVentana, altoVentana);
        crearMenu();
        nivel=new Label("Nivel ", LEFT);
        nivel.setBounds(900, 60, 100, 20);
        this.add(nivel);
        pnFondo=new Panel();
        pnFondo.setBounds(0,0,anchoVentana,altoVentana-(altoVentana-620));
        //pnFondo.setBackground(Color.yellow);
        this.add(pnFondo);
        
        puntuacion=new Label("Puntuacion: ", LEFT);
        puntuacion.setBounds(20, 660, 100, 20);
        this.add(puntuacion);
        pnLadrillo=new Panel();
        pnLadrillo.setBounds(posXLadrillo, 620, 60, 30);
        pnLadrillo.setBackground(Color.red);
        this.add(pnLadrillo);
        pnLineaFin=new Panel();
        pnLineaFin.setBounds(0, 620, anchoVentana, 30);
        pnLineaFin.setBackground(Color.gray);
        this.add(pnLineaFin);

        
        
        
        actualizar();
        this.addWindowListener(new WindowAdapter() { //cuando le das a la x se cierra el programa y la ventana
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
    public void crearMenu() {
        barraMenu = new MenuBar();
        mArchivo = new Menu("ARCHIVO");
        mLevel = new Menu("LEVEL");
        miSalir = new MenuItem("SALIR");
        miGuardar = new MenuItem("GUARDAR");
        miCargar = new MenuItem("CARGAR");
        //niveles = new CheckboxGroup();
        chbmiLevel = new CheckboxMenuItem[5];
        aniadirComponentesMenu();
    }
    public void aniadirComponentesMenu() {
        barraMenu.add(mArchivo);
        barraMenu.add(mLevel);
        miSalir.addActionListener(cMenu);
        mArchivo.add(miSalir);
        mArchivo.addSeparator();
        miGuardar.addActionListener(cMenu);
        mArchivo.add(miGuardar);
        miCargar.addActionListener(cMenu);
        mArchivo.add(miCargar);
        
        for (int i = 0; i < chbmiLevel.length; i++) {
            chbmiLevel[i] = new CheckboxMenuItem("Level" + (i + 1), false);
            chbmiLevel[i].setName((i + 1) + "");//id con el numero del nivel
            chbmiLevel[i].addItemListener(cMenu);
            // mscLevel=new MenuShortcut(KeyEvent.VK_(i+1));
            switch (chbmiLevel[i].getName()) {
                case "1":
                    mscLevel = new MenuShortcut(KeyEvent.VK_1);
                    break;
                case "2":
                    mscLevel = new MenuShortcut(KeyEvent.VK_2);
                    break;
                case "3":
                    mscLevel = new MenuShortcut(KeyEvent.VK_3);
                    break;
                case "4":
                    mscLevel = new MenuShortcut(KeyEvent.VK_4);
                    break;
                case "5":
                    mscLevel = new MenuShortcut(KeyEvent.VK_5);
                    break;
            }
            chbmiLevel[i].setShortcut(mscLevel);
            mLevel.add(chbmiLevel[i]);
        }
        setMenuBar(barraMenu);
        
    }

    public void actualizar() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("lalllalalalalla");
                mostrarBotones('a');
            }
        });
        timer.start();
    }
    public void mostrarBotones(char letra){
        int X=500;//(int)(Math.random()*(anchoVentana-anchoBoton));
        int Y=300;
        if(cont<20){
            arrayBtn[cont] = new Button();
            arrayBtn[cont].setLabel(letra + "");
            arrayBtn[cont].setBackground(Color.GREEN);
            //arrayBtn[cont].setName(id + "");
            arrayBtn[cont].addKeyListener(c);
            arrayBtn[cont].setBounds(X, Y, anchoBoton, anchoBoton);
            pnFondo.add(arrayBtn[cont]);
            cont++;
        }
        
        /*
        arrayBtn.add(new Button(letra+""));
        this.add(arrayBtn.get(cont));*/
        
    }
    public void setFondo(){ 
        pnFondo.setBackground(Color.orange);
        timer2 = new Timer(1000, new ActionListener() { //timer para que el color de fondo dure un segundo
            @Override
            public void actionPerformed(ActionEvent e) {
                pnFondo.setBackground(Color.white);
            }
        });
        timer2.start();
        
    }
    public void setLevel(int level){
        nivel.setText("Nivel: "+level);
    }
    public void setPuntos(int puntos){
        puntuacion.setText("Puntuacion: "+puntos);
    }
    public void quitarLetra(Component componente){
        pnFondo.remove(componente);
    }
    public void setPosicionLadrillo(int x){
        this.posXLadrillo=x;
        pnLadrillo.setBounds(posXLadrillo, 620, 60, 30);
    }
    public int getPosicionLadrillo(){
        return posXLadrillo;
    }/*
    public void mostrarLadrillo(){
        
    }*/
    public int getAnchoVentana() {
        return anchoVentana;
    }
    public int getAltoVentana() {
        return altoVentana;
    }
    public int getAnchoBoton() {
        return anchoBoton;
    }
}
