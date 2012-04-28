/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Herencia;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Cheque {
    public int numeroCheque;
    public String destinatario;
    public Date fecha;
    public double monto;
    
    public Cheque(int nc,String n,double m){
        numeroCheque = nc;
        destinatario = n;
        monto = m;
        fecha = new Date();
    }
    
    @Override
    public String toString(){
        return numeroCheque + "- a la orden de: " +
                destinatario + " monto: " + monto +
                " fecha: " + fecha;
    }
    
    
}
