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
public class CuentaBancaria {
    protected int numCuenta;
    protected String nombre;
    protected double saldo;
    protected Date inicio;
    
    public CuentaBancaria(int nc,String n){
        numCuenta = nc;
        nombre = n;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
    
    public String toStringAbuelo(){
        return super.toString();
    }
    
    
}
