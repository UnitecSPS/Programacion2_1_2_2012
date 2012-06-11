/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

import java.io.IOException;
import java.util.ArrayList;
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
            System.out.println("7- Export Inventario");
            System.out.println("8- Actualizar Precio");
            System.out.println("9- Cancion Popular");
            System.out.println("10-Inactivar Canciones");
            System.out.println("11- Salir");
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
                    case 7:
                        export();
                        break;
                    case 8:
                        actualizar();
                        break;
                    case 9:
                        popular();
                        break;
                    case 10:
                        inactivar();
                        break;
                }
                
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while( op != 11 );
        
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

    private static void export() throws IOException {
        System.out.print("Ingrese direccion de Arch. Texto: ");
        jt.exportInventario(lea.next());
    }

    private static void actualizar() throws IOException {
        System.out.println("Codigo de la cancion: ");
        int cod = lea.nextInt();
        System.out.println("Nuevo Precio: ");
        double p = lea.nextDouble();
        
        if( jt.updatePrecio(cod, p))
            System.out.println("Se actulizo correctamente");
        else
            System.out.println("No se pudo actualizar");            
    }

    private static void popular() throws IOException {
        System.out.println("Min Date: Y/M/D: ");
        Calendar c = Calendar.getInstance();
        c.set(lea.nextInt(), lea.nextInt() , lea.nextInt());
        
        System.out.println("Cancion Popular: " + jt.cancionPopular(c.getTime()));
    }

    private static void inactivar() {
        ArrayList<Integer> cods = new ArrayList<Integer>();
        char resp;
        
        do{
            System.out.println("Ingrese codigo: ");
            cods.add( lea.nextInt() );
            
            System.out.println("Desea otra?(s/n): ");
            resp = lea.next().charAt(0);
        }while(resp == 's');
    }
}
