/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class JavaBank {
    
    static ArrayList<iPrestamo> prestamos;
    
    public static Scanner lea = new Scanner(System.in);
    public static final int TIPO_VIVIENDA = 0;
    public static final int TIPO_AUTO = 1;
    
    public static void main(String args[]){
        
    }
    
    static void adicionarPrestamo(int tipo,   double montoPrestamo){
        if( tipo == TIPO_VIVIENDA ){
            prestamos.add( 
                    new PrestamoVivienda(montoPrestamo,lea.next(),100,true) );
        }
        else if( tipo == TIPO_AUTO ){
            prestamos.add(
                 new PrestamoAuto(montoPrestamo, lea.next(), 50, lea.next() )
                    );
        }
    }
    
    static double totalPendiente(){
        double pendiente = 0;
        for( iPrestamo ip : prestamos)
            pendiente += ip.saldoPendiente();
        return pendiente;
    }
    
    static void imprimirPendientes(){
        for( iPrestamo ip : prestamos ){
            double mp = ip.saldoPendiente();
            
            if( mp > 0 ){
                ((Prestamo)ip).imprimir();
            }
        }
    }
}
