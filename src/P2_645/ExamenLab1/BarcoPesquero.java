/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.ExamenLab1;

import java.util.Calendar;

/**
 *
 * @author Gotcha
 */
public class BarcoPesquero extends Barco{
    private int pecesCapturados;
    public static final int PRECIO_X_PESCADO = 150;
    
    public BarcoPesquero(String n){
        
        super(n);
        pecesCapturados = 0;
    }

    @Override
    public void agregarElemento() {
        pecesCapturados++;
    }

    @Override
    public String toString() {
        return super.toString() + "Peces Capturados: " + 
                pecesCapturados;
    }

    @Override
    public double vaciarCobrar() {
        double monto = pecesCapturados * PRECIO_X_PESCADO;
        pecesCapturados = 0;
        return monto;
    }
    
    public void agregarCardumen(int cant){
        pecesCapturados +=  cant;
    }
}
