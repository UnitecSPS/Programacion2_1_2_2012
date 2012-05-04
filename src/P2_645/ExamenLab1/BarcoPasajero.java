/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.ExamenLab1;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class BarcoPasajero extends Barco{
    private String pasajeros[];
    private double precioBoleto;
    private int contador;
    
    public BarcoPasajero( String n, double pb){
        super(n);
        precioBoleto = pb;
        pasajeros = new String[100];
        contador = 0;
    }

    @Override
    public void agregarElemento() {
        String resp;
        Scanner lea = new Scanner(System.in);
        
        do{
            if( contador < pasajeros.length ){
                System.out.println("Nombre Pasajero: ");
                String np = lea.next();
                
                pasajeros[contador] = np;
                contador++; 
                
                System.out.println("Desea ingresar otro?: ");
                resp = lea.next();
            }
            else{
                System.out.println("Arreglo lleno");
                break; //<-- parar ciclo
            }
                
        }while( resp.equals("SI") );
    }

    @Override
    public String toString() {
        return super.toString() + " Pasajeros que compraron boleto: " +
                contador;
    }

    @Override
    public double vaciarCobrar() {
        double monto = contador * precioBoleto;
        contador = 0;
        return monto;
    }
    
    public void listarPasajeros(){
        int cont = 0;
        for(String pasajero : pasajeros){
            if( cont == contador )
                break; //<---parar ciclo
            System.out.printf(" Pasajero: %s\n",pasajero);
            cont++;
        }
    }
}
