/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Archivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author CarlosArmando
 */
public class JBank {
    RandomAccessFile rCuentas;
    RandomAccessFile rLog;
    
    public JBank(){
        try{
            rCuentas = new RandomAccessFile("cuentas.bac", "rw");
            rLog = new RandomAccessFile("log.bac", "rw");
            initCodigos();
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void initCodigos() throws IOException {
        RandomAccessFile rCod = new RandomAccessFile("codigos.bac","rw");
        
        if( rCod.length() == 0 ){
            rCod.writeInt(1);
        }
        
        rCod.close();
        
    }
}
