/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Pirateria {
    static jTunes jt = new jTunes();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        
        int op = 0;
        
        do{
            System.out.println("\n1- Agregar Cancion");
            System.out.println("2- Listar Canciones disponibles");
            System.out.println("3- Votar Cancion");
            System.out.println("5- Salir");
            System.out.println("\nEscoja Opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch( op ){
                    case 1:
                        agregar();
                        break;
                    case 2:
                        jt.listarDisponibles();
                        break;
                    case 3:
                        votar();
                        break;
                }
                
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while( op != 5 );
        
    }

    private static void agregar() throws IOException {
        System.out.println("Ingrese Nombre: ");
        String n = lea.next();
        System.out.println("Ingrese Precio: ");
        double p = lea.nextDouble();
        System.out.println("Ingrese genero (POP, ROCK, RAP, COUNTRY): ");
        TipoGenero tp = TipoGenero.valueOf( lea.next() );
        
        jt.agregarCancion(n, p, tp);
    }

    private static void votar() throws IOException {
        System.out.println("Ingrese el Codigo: ");
        int cod = lea.nextInt();
        System.out.println("Cuantas Estrellas? 0-5: ");
        int stars = lea.nextInt();
        
        if( jt.votarCancion(cod, stars) )
            System.out.println("Votacion Correcta");
        else
            System.out.println("Votacion Incorrecta");
    }
}
