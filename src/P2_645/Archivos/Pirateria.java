/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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
            System.out.println("4- Bajar Cancion");
            System.out.println("5- Listar Facturas");
            System.out.println("6- Monto Generado");
            System.out.println("7- Salir");
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
                    case 4:
                        bajar();
                        break;
                    case 5:
                        jt.listarFacturas();
                        break;
                    case 6:
                        generado();
                        break;
                }
                
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while( op != 7 );
        
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

    private static void bajar() throws IOException {
        System.out.println("Cod Cancion: ");
        int cc = lea.nextInt();
        System.out.println("Username: ");
        String u = lea.next();
        
        if( jt.download(cc, u) )
            System.out.println("Se bajo correctamente");
        else
            System.out.println("No se pudo bajar");
    }

    private static void generado() throws IOException {
        //inicio
        System.out.println("Anio de Inicio//Mes de Inicio//Dia de Inicio//");
        Calendar c = Calendar.getInstance();
        c.set(lea.nextInt(), lea.nextInt() - 1, lea.nextInt() );
        c.add(Calendar.DATE, -1);
        Date inicio = c.getTime();
        System.out.println("Buscar Inicio: " + inicio);
        //fin
        System.out.println("Anio de Fin//Mes de Fin//Dia de Fin//");
        c.set(lea.nextInt(), lea.nextInt() - 1, lea.nextInt() );
        c.add(Calendar.DATE, 1);
        Date fin = c.getTime();
        System.out.println("Buscar Fin: " + fin);
        
        
        double m = jt.montoGenerado(inicio, fin);
        
        System.out.println("Monto: " + m);
    }
}
