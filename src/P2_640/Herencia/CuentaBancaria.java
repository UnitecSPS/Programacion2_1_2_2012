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
public abstract class CuentaBancaria {
    protected int numCuenta;
    protected String nombre;
    protected double saldo;
    protected Date inicio;
    
    public CuentaBancaria(int nc,String n,double sal){
        numCuenta = nc;
        nombre = n;
        saldo = sal;
        inicio = new Date();
    }

    public Date getInicio() {
        return inicio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        String dato = numCuenta + "-" + nombre + " Lps" + 
                saldo + " ----- ";
        return dato;
    }
    
    public void hacerDeposito(double monto){
        saldo += monto;
    }
    
    public boolean hacerRetiro(double monto){
        if( saldo > monto ){
            saldo -= monto;
            return true;
        }
        return false;
    }
    
    public abstract void Fua();
    
    
}
