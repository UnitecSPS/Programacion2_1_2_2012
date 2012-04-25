/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Herencia;

/**
 *
 * @author Gotcha
 */
public class CuentaAhorro extends CuentaBancaria{
    
    private double tasaInteres;
    private boolean activa;
    
    public CuentaAhorro(int nc,String n,double ts){
        super(nc, n);
        tasaInteres = ts;
        activa = true;
        
        System.out.println(this.toStringAbuelo());
        
    }
}
