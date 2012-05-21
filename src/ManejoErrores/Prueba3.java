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
public class Prueba3 {
    static ArregloEntero ae;
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        ae = new ArregloEntero();
        int index = lea.nextInt();
        test(4.9, index);
    }
    
    public static void test(Object valor, int index){
        
        try{           
            ae.guardarEn(index, valor);
        }
        catch(InvalidValueException e){
            System.out.println("Valor Incorrecto: " + 
                    e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }  
    }
}
