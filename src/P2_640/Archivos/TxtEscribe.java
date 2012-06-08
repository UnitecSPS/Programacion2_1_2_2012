/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Archivos;

import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author CarlosArmando
 */
public class TxtEscribe {
    public static void main(String args[]){
        FileWriter fw;
        Scanner lea = new Scanner(System.in);
        
        try{
            System.out.println("Ingrese dir de archivo: ");
            String path = lea.next();
            System.out.println("Lo quiere append?: ");
            char resp = lea.next().charAt(0);
            
            fw = new FileWriter( path , resp == 's' ? true : false );
            
            
            do{
                System.out.println("Ingrese algo a escribir: ");
                String texto = lea.nextLine();
                
                if( texto.equals("SALIR") )
                    break;
                else{
                    fw.write( texto + "\r\n");
                    fw.flush();
                }
                
            }while(true);
            
            fw.close();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
