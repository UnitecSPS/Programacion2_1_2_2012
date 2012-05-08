/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Gotcha
 */
public class ReinoAnimal {
    public static void main(String args[]){
        ArrayList<Animal> animales = new ArrayList<Animal>();
        
        animales.add( new Chihuahua() ) ;
        animales.add( new Vaca() );
        animales.add( new Gato() );
        
        for(Animal ani : animales){
            ani.comoHabla();
        }
        
        if( animales.get(0) instanceof Vaca ){
            System.out.println("PERRO!!");
        }
        
        Animal g = new Gato(){

            @Override
            public void comoHabla() {
                System.out.println("MIIIIIIIAUU");
            }
            
        };
        g.comoHabla();
        
        Animal a = new Animal(4,false) {

            @Override
            public void comoHabla() {
                System.out.println("ELLLA SOY ANIMAL ARGGG");
                this.wazup();
            }
            
            public void wazup(){
                System.out.println("wazup");
                
            }
        };
        
        a.comoHabla();
        
        
    }
}
