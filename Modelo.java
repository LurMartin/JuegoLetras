package juegoletras;

public class Modelo {
    private int puntuacion;
    private Letra letra;
    private Ladrillo ladrillo;
    private int contadorLetras;
    private Controlador controlador;
    private int level;
    private int velocidad;

    public Modelo(Controlador control) {
        this.controlador=control;
    }
    public void iniciar(){
        //letra=new Letra();
        ladrillo=new Ladrillo();
        puntuacion=0;
        contadorLetras=0;
    }
    public void generarLetra(){
       letra=new Letra(this);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    
}
