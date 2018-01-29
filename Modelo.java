/*
 para crear la letra vamos para que el label tenga la letra he visto que hay que pasarle por parametro la letra
ya que es el controlador quien tiene la letra, o el array de letras va en letras o en el mismo modelo.
 */
package juegointefaces;

/**
 *
 * @author Marta
 */
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
