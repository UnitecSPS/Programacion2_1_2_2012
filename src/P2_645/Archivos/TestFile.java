/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gotcha
 */
public class TestFile {
    
    public static void main(String args[]){
        Scanner lea = new Scanner(System.in);
        FileActions fa = new FileActions();
        int op;
        
        do{
            System.out.println("1- Configurar Archivo");
            System.out.println("2- Crear Archivo");
            System.out.println("3- Crear Directorio");
            System.out.println("4- Ver Informacion");
            System.out.println("5- Borrar");
            System.out.println("10- Salir");
            System.out.println("Ingrese OPcion: ");
            op = lea.nextInt();
            
            switch( op ){
                case 1:
                    System.out.print("Ingrese direccion: ");
                    fa.setFile( lea.next() );
                    break;
                case 2:
                    try {
                        if( fa.crearArchivo() )
                            System.out.println("Se creo masiso");
                        else
                            System.out.println("No se pudo crear");
                    } catch (IOException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;
                case 3:
                    if( fa.crearDirectorio() )
                        System.out.println("El directio se creo bien");
                    else
                        System.out.println("No se pudo crear directorio");
                    break;
                case 4:
                    fa.info();
                    break;
                case 5:
                    if( fa.borrar() )
                        System.out.println("Se borro masiso");
                    else
                        System.out.println("No se pudo borrar");
                    break;
            }
        }while( op != 10 );
        
        
    }
}
