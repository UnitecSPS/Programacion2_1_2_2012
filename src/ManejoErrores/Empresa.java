/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoErrores;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Empresa {
    public static void main(String args[]){
        patito();
        Empleado em = new Empleado("aCa");
        
        try{
            em.setZona('a');
            System.out.println("BIEN");
            em.setZona('x');
        }
        catch(Exception e){
            System.out.println("NO LLEGO! :( PORQUE: " +
                    e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void patito(){
        Scanner lea = new Scanner(System.in);
        do{
            try{
                int x = lea.nextInt();
            
                System.out.println("TERMINA TRY");
                break;
            }
            catch(Exception e){
                lea.next();
                System.out.println("Mensaje: " + e.getMessage());
                //e.printStackTrace();
            }
        }while(true);
        
        System.out.println("BLOQUE FINAL");
    }
}
