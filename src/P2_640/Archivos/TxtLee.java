/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Archivos;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class TxtLee {
    public static void main(String args[]){
        Scanner lea = new Scanner(System.in);
        
        try{
            System.out.println("Ingresen la direccion del txt: ");
            File file = new File(lea.next());
            
            FileReader fr = new FileReader(file);
            char buffer[] = new char[ (int)file.length() ];
            //CharBuffer  cb = CharBuffer.allocate((int)file.length());
            int leido = fr.read(buffer);
            System.out.println("Contenido:\n-------\n");
            System.out.println(buffer);
            System.out.println("Cantidad leida: " + leido +
                    " size del arch: " + file.length());
            
            //leerr con el Scanner
            System.out.println("\n\nCON SCANNER");
            fr = new FileReader(file);
            Scanner lector = new Scanner(fr);
             
            while( lector.hasNext() ){
                System.out.println(lector.nextLine());
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
