/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Examen1;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class CableColor {
    private static Servicio services[];
    
    public static void main(String args[]){
        services = new Servicio[100];
    }
    
    public static void imprimirServicios(){
        for( Servicio serv : services ){
            if( serv != null )
                serv.imprimir();
        }
    }
    
    public static int posVacia(int pos){
        if( pos < services.length ){
            if( services[pos] == null )
                return pos;
            return posVacia( pos + 1 );
        }
        return -1;
    }
    
    public static void agregarServicio(String serviceType){
        Scanner lea = new Scanner(System.in);
        
        int pos = posVacia( 0 );
        
        if( pos > 0 ){
            int codigo = lea.nextInt();
            String n = lea.next();
            
            if( serviceType.equals("TV") ){
                int cant = lea.nextInt();
                boolean b = lea.hasNextBoolean();
                
                services[ pos ] = new TVService(codigo,n,cant,b);
            }
            else if( serviceType.equals("INTERNET")){
                int ancho = lea.nextInt();
                
                services[ pos ] = new InternetService(codigo,n,ancho);
            }
            else
                System.out.println("TIPO INCORRRECTO");
        }
    }
    
    public static boolean buscarCanalServicio(int index,String canal){
        if( index < services.length ){
            if( services[index] != null ){
                if( services[index] instanceof TVService)
                    return ((TVService)services[index]).buscar(canal,0);
            }
        }
        return false;
    }
    
    public static void estadistica(){
        int ctv= 0, cint= 0;
        
        for(Servicio serv : services){
            if( serv instanceof TVService)
                ctv++;
            else if( serv instanceof InternetService)
                cint++;
        }
        
        System.out.println(ctv + "-" + cint);
    }
}
