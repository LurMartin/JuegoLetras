
package juegoletras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControladorMenu implements ActionListener, ItemListener{
    private Vista vista;
    public ControladorMenu(Vista vista){
        this.vista=vista;
    }
    
    /**
     * 
     * @param ae elemento del menú sobre el que se realiza la acción, en este caso
     * serán MenuItems
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.paramString()) {
                case "Salir":
                    //modelo.exit();
                    break;
                case "Guardar":
                    //modelo.guardar(vista.guardar);
                    break;
                case "Cargar":
                    //cargar info
                    break;
            }
    }

    /**
     * 
     * @param ie : Recibe el item que hay sido seleccionado o deseleccionado
     */
    @Override
    public void itemStateChanged(ItemEvent ie) {
        //si el elemento se selecciona (solo podrá haber uno seleccionado al se run grupo
        if(ie.getStateChange()==1) {
            //se le pasa al modelo el id del item. Este id será el número del nivel
            modelo.setLevel(ie.getID());
        }
        
    }
    
}
