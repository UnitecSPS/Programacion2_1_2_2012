/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

/**
 *
 * @author Gotcha
 */
public class Vaca extends Animal{
    
    public Vaca(){
        super(4,true);
    }

    @Override
    public void comoHabla() {
        System.out.println("MUUUU MUUUU");
    }
    
}
