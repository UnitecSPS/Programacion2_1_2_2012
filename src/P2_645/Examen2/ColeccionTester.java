/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Examen2;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class ColeccionTester {
    static iCollection cols[] = new iCollection[10];
    static int cont = 0;
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        
    }
    
    static boolean agregarColeccion( Coleccion tipo ){
        try{
            if( tipo == Coleccion.CHAR)
                cols[ cont ] = new ColeccionChar();
            else if( tipo == Coleccion.DOUBLE )
                cols[ cont ] = new ColeccionDouble();
            else if( tipo == Coleccion.INTEGER )
                cols[ cont ] = new ColeccionEntera();
            else
                cols[ cont ] = new ColeccionString();
            cont++;
            return true;
            
        }
        catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Ya no hay espacio");
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return false;
    }
    
    static boolean agregarElementoColeccion( int posCol ){
        try{
            if( cols[ posCol ] instanceof ColeccionChar )
                cols[ cont ].agregar( lea.next().charAt(0) );
            else if( cols[ posCol ] instanceof ColeccionDouble )
                cols[ cont ].agregar( lea.nextDouble() );
            else if( cols[ posCol ] instanceof ColeccionEntera )
                cols[ cont ].agregar( lea.nextInt() );
            else
                cols[ cont ].agregar( lea.next() );
            cont++;
            return true;
            
        }
        catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Posicion Incorrecta");
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return false;
    }
    
    static void Estadistica(){
        for( iCollection ic : cols ){
            System.out.println("Tipo: " + ic.getTipo());
            ((MiColeccion)ic).imprimirColeccion();
        }
    }
    
    static boolean buscarEnColeccion( int posCol ){
        try{
            if( cols[ posCol ] instanceof ColeccionChar )
                return ((iCollActions)cols[posCol]).buscarElemento( lea.next().charAt(0) );
            else if( cols[ posCol ] instanceof ColeccionDouble )
                return ((iCollActions)cols[posCol]).buscarElemento( lea.nextDouble() );
            else if( cols[ posCol ] instanceof ColeccionEntera )
                return ((iCollActions)cols[posCol]).buscarElemento( lea.nextInt() );
            else
                return ((iCollActions)cols[posCol]).buscarElemento( lea.next() );
           
        }
        catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Posicion Incorrecta");
        }
        return false;
    }
}
