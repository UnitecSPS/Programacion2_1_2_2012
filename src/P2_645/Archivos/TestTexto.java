/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gotcha
 */
public class TestTexto {
    public static void main(String args[]){
        Scanner lea = new Scanner(System.in);
        FileWriter fw = null;
        char resp = 's';
                
        do{
            System.out.println("Ingrese dir de Arch Texto: ");
            String path = lea.next();
            System.out.println("Lo quiere append? ");
            char app = lea.next().charAt(0);
            
            try {
                fw = new FileWriter(path , app == 's' ? true : false);
                
                String texto;
                
                do{
                    System.out.println("Texto a Escribir: ");
                    texto = lea.nextLine();
                    
                    if( !texto.equals("SALIR")){
                        fw.write( texto + "\n" );
                        fw.flush();
                    }
                    
                }while( !texto.equals("SALIR"));
                
                System.out.println("Quiere otro archivo?: ");
                resp = lea.next().charAt(0);
                
                if( resp != 's' )
                    fw.close();
                
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            
        }while(resp == 's');
        
        //leer de texto
        System.out.println("Dir de Arch txt: ");
        try{
            File file = new File(lea.next());
            FileReader fr = new FileReader(file);
            
            char buffer[] = new char[(int)file.length()];
            int bleidos = fr.read(buffer);
            
            System.out.println("Contenido:\n");
            System.out.println(buffer);
            System.out.println("Cantidad leida: " + bleidos + 
                    " size del archivo: " + file.length());
            
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
