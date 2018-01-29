/*

 */
package juegointefaces;

/**
 *
 * @author Marta
 */
public class Letra {
    private int posX;
    private int posY;
    private Modelo modelo;

    public Letra(Modelo model) {
        this.modelo=model;
    }
    
    public void bajar(){
        posX+=5;
    }
    public void subir(){
        posX-=5;
    }
    public String generarLetra(int nivel){
        char[] letras={'a','s','d','ñ','l','k','j','f','g','h','q','w','e','p','o','i','u','y','r','t','m','n','z','x','c','v','b'};
        String letra;
        int random=0;
        switch(nivel){
            case 1:
              random=(int)Math.random()*6;
              break;
            case 2:
              random=(int)Math.random()*10;
              break;
            case 3:
              random=(int)Math.random()*16;
              break;
            case 4:
              random=(int)Math.random()*20;
              break;
            case 5:
              random=(int)Math.random()*27;
              break;           
        }
        return letra=""+letras[random];
    }
}
