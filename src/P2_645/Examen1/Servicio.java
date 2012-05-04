/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Examen1;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Servicio {
    protected int codigo;
    protected String nombre;
    protected Date inicio;
    protected double monto;
    
    public Servicio( int c, String n){
        codigo = c;
        nombre = n;
        inicio = new Date();
    }
    
    public void imprimir(){
        System.out.println(codigo + " - " +
                nombre + " - " + monto + " - " +
                inicio);
    }
    
    public double getMontoMensual(){
        return monto;
    }
}
