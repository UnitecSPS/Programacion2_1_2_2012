
package P2_640.ExamenLab1;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class VideoClub {
    public static ArrayList<ITEMRenta> items;
    public static Scanner lea=new Scanner(System.in);
    
    public static void main(String args[]){
        System.out.println("\tMASTERVIDEO/MASTERGAME");
        int opcion;
        do{
            System.out.println("1. Agregar Item");
            System.out.println("2. Imprimir Inventario");
            System.out.println("3. Generar renta");
            System.out.println("4. Listar Actores");
            System.out.println("5. Salir");
            System.out.println("Elija Opcion (1-5): ");
            opcion=lea.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese Tipo: ");
                    agregarItem( lea.nextInt() );
                    break;
                case 2:
                    imprimirInventario();
                    break;
                case 3:
                    System.out.println("Ingrese Codigo de Item: ");
                    double renta = generarRenta( lea.nextInt() );
                    System.out.println("Monto Generado: " + renta);
                    break;
                case 4:
                    System.out.println("Ingrese Codigo del DVD: ");
                    listarActores( lea.nextInt() );
                    break;
            }
        }while(opcion != 5);
    }
    
    public static void agregarItem(int tipo){
        
        if(tipo==0||tipo==1){
            System.out.println("CODIGO: ");
            int c=lea.nextInt();
            System.out.println("NOMBRE: ");
            String n=lea.next();
            System.out.println("PRECIO: ");
            double p=lea.nextDouble();
            System.out.println("CANTIDAD DE COPIAS: ");
            int cantcopias=lea.nextInt();
            if(tipo==0){
                System.out.println("GENERO: ");
                String g=lea.next();
                System.out.println("DURACION: ");
                double d=lea.nextDouble();
                items.add(new DVD_Renta(c,n,p,cantcopias,g,d));
            }else if(tipo == 1 ){
                System.out.println("TIPO CONSOLA: ");
                String ty=lea.next();
                items.add(new GAME_Renta(c,n,p,cantcopias,ty));
            }
        }else{
            System.out.println("ERROR DE TIPO DE RENTA");
        }
        
    }
    
    private static void imprimirInventario(){
        int cdvd = 0, cgames = 0;
        
        for(ITEMRenta i:items){
            i.imprimir();
            if(i instanceof DVD_Renta){
                cdvd=+1;
            }else if(i instanceof GAME_Renta){
                cgames+=1;
            }
        }
        System.out.println("CANTIDAD DE DVDS: "+ cdvd+"\nCANTIDAD DE JUEGOS: "+cgames);
    }
    
    private static double generarRenta(int codigo){
        for(ITEMRenta item : items){
            if(item.codigo==codigo){
                if(item.cantcopias >= 1 ){
                    System.out.println("CANTIDAD DIAS: ");
                    int days=lea.nextInt();
                    return item.getMontoRenta(days);
                }else{
                    System.out.println("NO HAY COPIAS DISPONIBLES");
                    return 0;
                }
            }
        }
        
        System.out.println("NO EXISTE ITEM");
        return 0;
    }
    
    private static void listarActores(int codigo){
        for(ITEMRenta item : items){
            if( item.codigo == codigo && 
                item instanceof DVD_Renta ){
                ((DVD_Renta)item).listarActores();
                return;//me salgo de la funcion
            }
        }
        
        System.out.println("NO EXISTE ITEM");
        
    }
}
