/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Amnet {
    private static ArrayList<Servicio> servicios;
    
    public static void main(String args[]){
        servicios = new ArrayList<Servicio>();
        //y se llamarian las funciones abajo definidas
        imprimir();
        agregarServicio("TV");
        boolean res = buscarCanalEnServicio(1,"TVC");
    }

    private static void imprimir() {
        for(Servicio serv : servicios)
            serv.imprimir();
    }

    private static void agregarServicio(String servType) {
        Scanner lea = new Scanner(System.in);
        
        int cod = lea.nextInt();
        String nombre = lea.next();
        
        if( servType.equals("TV") ){
            int cant = lea.nextInt();
            boolean digi = lea.hasNextBoolean();
            
            servicios.add( new TVService(cod,nombre,cant,digi) );
        }
        else if( servType.equals("INTERNET") ){
            int ancho = lea.nextInt();
            servicios.add( new InternetService(cod,nombre,ancho) );
        }
        else
            System.out.println("TIPO INCORRECTO");
    }

    private static boolean buscarCanalEnServicio(int cod, String canal) {
        for(Servicio serv : servicios){
            if( serv.codigo == cod){
                if( serv instanceof TVService )
                    return ((TVService)serv).buscar(canal, 0);
            }
        }
        return false;
    }
    
    
    
    
}