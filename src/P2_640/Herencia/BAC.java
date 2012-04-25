/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Herencia;

/**
 *
 * @author Gotcha
 */
public class BAC {
    public static void main(String args[]){
        //UPCASTINGS
        CuentaBancaria cb = new CuentaAhorro(1,"Messi",0.5);
        System.out.println(cb);
        
        
    }
}
