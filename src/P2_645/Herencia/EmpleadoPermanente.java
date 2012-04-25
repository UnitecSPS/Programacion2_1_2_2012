/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class EmpleadoPermanente extends Empleado{
    protected double salario;
    protected boolean hasSeguro;
    
    public EmpleadoPermanente(int c , String n,double s){
        super(c,n);
        hasSeguro = false;
        salario = s;
    }

    @Override
    public double calcularPagoMensual() {
        return super.calcularPagoMensual();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
