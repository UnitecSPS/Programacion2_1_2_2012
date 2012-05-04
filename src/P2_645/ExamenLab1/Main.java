/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.ExamenLab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Main {
    private static ArrayList<Barco> barcos;
    private static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        barcos = new ArrayList<Barco>();
        int op;
        
        do{
            System.out.println("\n\nMENU PRINCIPAL");
            System.out.println("1- Agregar Barco");
            System.out.println("2- Agregar Elemento");
            System.out.println("3- Vaciar Cobrar");
            System.out.println("4- Listar Pasajeros");
            System.out.println("5- Listar Barcos");
            System.out.println("6- Desactivar Barco");
            System.out.println("7- Salir");
            System.out.println("\nIngrese opcion: ");
            op = lea.nextInt();
            
            switch( op ){
                case 1:
                    System.out.println("Tipo? Pesquero(0) Pasajero(1): ");
                    agregarBarco( lea.nextInt() );
                    break;
                case 2:
                    System.out.println("Ingrese Nombre barco: ");
                    agregarElemento( lea.next() );
                    break;
                case 3:
                    System.out.println("Ingrese Nombre barco: ");
                    double monto = vaciarBarco( lea.next() );
                    System.out.println("Monto generado: " + monto);
                    break;
                case 4:
                    listarPasajeros();
                    break;
                case 5:
                    listarBarcos();
                    break;
                case 6:
                    System.out.println("Ingrese Nombre barco: ");
                    desactivarBarco( lea.next() );
            }
        }while( op != 7);
        
    }

    private static void agregarBarco(int tipo) {
        System.out.println("Nombre: ");
        String n = lea.next();
        
        if( tipo == 0 ){
            barcos.add( new BarcoPesquero(n) );
        }
        else if( tipo == 1){
            System.out.println("Precio Boleto: ");
            double pb = lea.nextDouble();
            
            barcos.add( new BarcoPasajero(n,pb) );
        }
        else
            System.out.println("TIPO INCORRECTO");
    }

    private static void agregarElemento(String nombre) {
        for(Barco ship : barcos){
            if( ship.getNombre().equals(nombre) &&
                ship.isCirculando() ){
                ship.agregarElemento();
                return; //<--termino la funcion
            }
        }
        System.out.println("NO SE ENCONTRO BARCO");
    }

    private static double vaciarBarco(String nombre) {
        for(Barco ship : barcos){
            if( ship.getNombre().equals(nombre) &&
                ship.isCirculando() ){
                return ship.vaciarCobrar();
            }
        }
        return 0;
    }

    private static void listarPasajeros() {
        for(Barco ship : barcos){
            if( ship instanceof BarcoPasajero && 
                ship.isCirculando() ){
                System.out.println("\nPasajeros en " + ship.getNombre());
                System.out.println("-------------------------------");
                ((BarcoPasajero)ship).listarPasajeros();
            }
                
        }
    }

    private static void listarBarcos() {
        for(Barco ship : barcos){
            if( ship.isCirculando() )
                System.out.println(ship);
        }
    }

    private static void desactivarBarco(String nombre) {
        for(Barco ship : barcos){
            if( ship.getNombre().equals(nombre) &&
                ship.isCirculando() ){
                ship.desactivar();
                System.out.println("SE DESACTIVO");
                return; //terminar funcion
            }
        }
        System.out.println("NO SE ENCONTRO BARCO");
    }
}
