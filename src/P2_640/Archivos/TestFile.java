/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Archivos;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Gotcha
 */
public class TestFile {
    public static void main(String args[]){
        
        try{
            viruloso(5);
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    public static void viruloso(int cant) throws IOException{
        
        for( int d = 1; d <= cant ; d++){
            String dirname = "Test/Viruloso" + d;
            File dir = new File( dirname );
            dir.mkdirs();
            
            for( int f = 1; f <= 10; f++ ){
                File arch = new File( dirname + "/archi" + f + ".txt" );
                arch.createNewFile();
            }
        }
    }
}
