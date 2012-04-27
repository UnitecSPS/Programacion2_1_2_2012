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
        CuentaBancaria cb1 = new CuentaAhorro(1,"Messi",0.5);
        CuentaBancaria cb2 = new CuentaPlazoFijo(3,"Kaka");
        //NORMAL
        CuentaBancaria cb3 = new CuentaBancaria(2,"Dany",100);
        
        cb1.Fua();
        cb2.Fua();
        cb3.Fua();
        
    }
}
