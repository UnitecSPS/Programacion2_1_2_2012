/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

/**
 *
 * @author Gotcha
 */
public abstract class Animal {
    protected int cantPatas;
    protected boolean isMamifero;
    
    public Animal(int cp , boolean im){
        cantPatas = cp;
        isMamifero = im;
    }

    public int getCantPatas() {
        return cantPatas;
    }

    public boolean isIsMamifero() {
        return isMamifero;
    }
    
    public abstract void comoHabla();
}
