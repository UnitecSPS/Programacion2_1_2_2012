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
        
        Animal a = new Animal(4,false){

            @Override
            public void comoHabla() {
                wazup();
                System.out.println("SOY ANIMAL GRUIUI");
            }
            
            public void wazup(){
                System.out.println("WAZZUUOP");
                System.out.println("");
            }
        };
        
        a.comoHabla();
        
        
    }
}
