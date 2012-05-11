/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public abstract class Empleado {
    protected String nombre;
    protected int codigo;
    protected Date inicio; 
    protected Date nacimiento;
    protected String localidad;

    public Empleado(int c, String no){
        codigo = c;
        nombre = no;
        inicio = new Date();
    }

    public final int getCodigo() {
        return codigo;
    }

    public final Date getInicio() {
        return inicio;
    }

    public final String getLocalidad() {
        return localidad;
    }

    public final Date getNacimiento() {
        return nacimiento;
    }

    public final String getNombre() {
        return nombre;
    }
    
    public final void setLocalidad(String localidad) {
        this.localidad = localidad;
    } 

    /**
     * 
     * @param nacimiento 
     */
    public final void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public  String toString() {
        return codigo + " - " + nombre;
    }
    
    public abstract double calcularPagoMensual();
    
    public void fua(){
        System.out.println("EMPLEADO FUAAA");
    }
    
}
   