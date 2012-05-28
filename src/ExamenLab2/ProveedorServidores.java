/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class ProveedorServidores {
    static ArrayList<Servidor> servidores = new ArrayList<Servidor>();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
        int op;
        do{
            System.out.println("\n\n1- Agregar Servidor");
            System.out.println("2- Agregar Entry");
            System.out.println("3- Navegar");
            System.out.println("4- Ver Detalle");
            System.out.println("5- Consultar DNS");
            System.out.println("6- Salir");
            System.out.print("Escoja Opcion: ");
            op = lea.nextInt();
            
            try{
                switch( op ){
                    case 1:
                        System.out.println("Ingrese tipo servidor HTTP o DNS: ");
                        agregarServidor( TipoProtocolo.valueOf(lea.next()) );
                        break;
                    case 2:
                        System.out.println("Ingrese el Numero IP: ");
                        agregarEntry( lea.next() );
                        break;
                    case 3:
                        System.out.print("URL: http:\\\\");
                        navegar( lea.next() );
                        break;
                    case 4:
                        System.out.println("Ingrese tipo servidor HTTP o DNS: ");
                        detalles( TipoProtocolo.valueOf(lea.next()) );
                        break;
                    case 5:
                        System.out.println("Ingrese Url o ip: ");
                        consultaDNS( lea.next() );
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while( op!= 6 );
    }

    private static Servidor ipExiste(String ip){
        for(Servidor s : servidores){
            if( s.getIp().equals(ip) )
                return s;
        }
        return null;
    }
    
    private static void agregarServidor(TipoProtocolo tipo) {
        System.out.println("Ingrese direccion IP: ");
        String ip = lea.next();
        
        if( ipExiste(ip) == null ){
            if( tipo == TipoProtocolo.HTTP )
                servidores.add( new ServidorWeb(ip) );
            else
                servidores.add( new ServidorDNS(ip) );
        }
        else{
            System.out.println("IP YA EXISTE");
        }
            
    }

    private static void agregarEntry(String ip) {
        Servidor server = ipExiste(ip);
        
        if( server != null ){
            //si existe el servidor
            String key, registro;
            
            if( server instanceof ServidorWeb ){
                System.out.print("Ingrese URL o Dominio: ");
                key = lea.next();
                System.out.print("Ingrese contenido de la pagina: ");
                registro = lea.next();
            }
            else{
                System.out.print("Ingrese Direccion ip del Entry: ");
                key = lea.next();
                System.out.print("Ingrese Url o Dominio: ");
                registro = lea.next();
            }
            
            if( server.agregarEntry(key, registro) )
                System.out.println("Se agrego Satisfactoriamente");
            else
                System.out.println("No se pudo agregar Entry");
        }
    }

    private static void navegar(String url) {
        //primero buscamos el url en los DNS para sacar el ip del 
        //Servidor Web donde esta ese dominio
        String ip = "";
        for(Servidor server : servidores){
            if( server instanceof ServidorDNS ){
                try{
                   ip = server.devolverPeticion(url).toString();
                }catch(Exception e){
                    //quiere decir que no esta ese url en ese DNS
                    //seguimos con el for
                }
            }
        }
        
        if( !ip.equals("") ){
            //quiere decir que econtramos el servidor web, ahora busquemos
            //ese servidor
            Servidor server = ipExiste(ip);
            
            if( server != null ){
                //encontramos el servidor!! ahora busquemos el dominio!
                try{
                    Object contenido = server.devolverPeticion(url);
                    System.out.println(contenido);
                    return; //me salgo!!
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        //si llego aqui es que nunca lo encontre
        System.out.println("404 PAGE NOT FOUND");
    }

    private static void detalles(TipoProtocolo tipo) {
        for(Servidor server : servidores){
            if( (tipo == TipoProtocolo.HTTP && server instanceof ServidorWeb) ||
                (tipo == TipoProtocolo.DNS && server instanceof ServidorDNS)  )
                server.printInformacion();
        }
    }

    private static void consultaDNS(String key) {
        String error = "";
        for(Servidor server : servidores){
            if( server instanceof ServidorDNS ){
                try{
                    Object registro = server.devolverPeticion(key);
                    System.out.println("Registro: ");
                    System.out.println(registro);
                    return;
                }
                catch(Exception e){
                    error = e.getMessage();
                }
            }
        }
        System.out.println(error);
    }
}
