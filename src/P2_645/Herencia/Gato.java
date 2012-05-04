/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

/**
 *
 * @author Gotcha
 */
public class Gato extends Animal{

    public Gato(){
        super(4,true);
    }
    
    @Override
    public void comoHabla() {
        System.out.println("MIAU MIAU");
    }
    
}
