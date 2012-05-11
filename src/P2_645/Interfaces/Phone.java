/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Interfaces;

/**
 *
 * @author Gotcha
 */
public class Phone {
    public int numero;
    public boolean camara;
    
    public Phone(int n){
        numero = n;
        camara = false;
    }
    
    public int getNumero(){
        return numero;
    }
}
