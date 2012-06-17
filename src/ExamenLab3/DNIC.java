/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab3;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class DNIC {
    public static void main(String args[]){
        int resp;
        Transito tran = new Transito();
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("1- Agregar Esquela");
            System.out.println("2- Pagar Esquela");
            System.out.println("3- Listar Esquelas");
            System.out.println("4- Ver Log");
            System.out.println("5- Salir");
            System.out.println("\nEscoja opcion: ");
            resp = lea.nextInt();
            
            try{
                switch(resp){
                    case 1:
                        System.out.println("Infractor: ");
                        String i = lea.next();
                        System.out.println("Tipo (LEVE,MEDIANA, GRAVE): ");
                        TipoEsquela tipo = TipoEsquela.valueOf(lea.next());
                        
                        tran.agregarEsquela(i, tipo);
                        break;
                    case 2:
                        System.out.println("Ingrese Codigo: ");
                        tran.pagarEsquela(lea.nextInt());
                        break;
                    case 3:
                        System.out.println("Ingrese fecha Minima YY/MM/DD: ");
                        Calendar c = Calendar.getInstance();
                        c.set(lea.nextInt(),lea.nextInt()-1,lea.nextInt());
                        tran.listar(c.getTime());
                        break;
                    case 4:
                        tran.leerLog();
                        break;
                    case 5:
                        tran.close();
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(resp != 5);
    }
}
