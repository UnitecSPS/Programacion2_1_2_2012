/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.ExamenLab1;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public abstract class Barco {
    protected String nombre;
    protected boolean circulando;
    protected Date inicio;
    
    public Barco(String n){
        nombre = n;
        circulando = true;
        inicio = new Date();
    }

    public boolean isCirculando() {
        return circulando;
    }

    public Date getInicio() {
        return inicio;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString(){
        return nombre + " - Circula desde: " + inicio + " activo? : " +
                circulando;
    }
    
    public abstract void agregarElemento();
    
    public abstract double vaciarCobrar();
    
    public void desactivar(){
        Date now = new Date();
        circulando = false;
        
        long diff = now.getTime() - inicio.getTime();
        //pasar los ms a dias
        long dias = diff/(1000*60*60*24);
        System.out.println("Dias circulando: " + dias);
    }
}
