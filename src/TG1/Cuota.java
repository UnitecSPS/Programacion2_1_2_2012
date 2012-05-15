/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG1;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Cuota {
    public double monto;
    public boolean pagada = false;
    public Date fechaDePago = null;
    
    public Cuota(double mo){
        monto = mo;
    }
    
    @Override
    public String toString(){
        String dato =  "Lps. " + monto;
        
        if( pagada )
            dato += " Fue Pagada en " + fechaDePago;
        else
            dato += " Esta Pendiente";
        return dato;
    }
}





