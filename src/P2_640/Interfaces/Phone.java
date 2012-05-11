/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Interfaces;

/**
 *
 * @author CarlosArmando
 */
public abstract class Phone {
    public static final String phone_version = "YUYs";
    protected int numero;
    
    public Phone(int n){
        numero = n;
    }
    
    public abstract void imprimir();
}
