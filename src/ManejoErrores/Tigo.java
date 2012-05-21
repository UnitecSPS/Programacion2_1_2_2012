/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoErrores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Tigo {
    public static void main(String args[]){
        fua();
        
        Plan p = new Plan("Melvin");
        p.setPlan("TARJETA");
        System.out.println("Tipo Plan: " + p.tp );
        
        //
        System.out.println("Name " + TipoPlan.CORPORATIVO.name());
        System.out.println("Ordinal " + TipoPlan.TARJETA.ordinal());
        System.out.println("Max Mins de " + TipoPlan.CORPORATIVO + ""
                + " son: " + TipoPlan.CORPORATIVO.getMaxMins());
    }

    private static void fua() {
        Scanner lea = new Scanner(System.in);
        do{
            try{
                lea.nextInt();
                break;
            }
            catch(Exception e){
                if( e instanceof InputMismatchException )
                    lea.next();
                System.out.println("Error: " + e.getMessage());
            }
        }while(true);
        
        System.out.println("BLOQUE FINAL");
    }

    private static void patito() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
