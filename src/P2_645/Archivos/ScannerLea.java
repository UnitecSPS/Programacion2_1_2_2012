/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gotcha
 */
public class ScannerLea {
    public static void main(String args[]){
        Scanner lea = new Scanner(System.in);
        System.out.println("Dir de Arch txt: ");
        
        try {
            FileReader fr = new FileReader(lea.next());
            Scanner lector = new Scanner( fr );
            //lector.useDelimiter(System.getProperty("line.separator"));
            
            while( lector.hasNext()){
                System.out.println( lector.nextLine());
            }
            
            
        } catch (FileNotFoundException ex) {
        }
        
        
    }
}
