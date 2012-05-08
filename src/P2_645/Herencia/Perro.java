/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

/**
 *
 * @author Gotcha
 */
public abstract class Perro extends Animal {
    
    public Perro(){
        super(4,true);
    }
    
    @Override
    public void comoHabla(){
        System.out.println("GUA GUA GUA GUA");
    }
    
    public abstract void queRaza();
}
