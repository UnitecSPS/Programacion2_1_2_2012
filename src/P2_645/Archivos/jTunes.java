/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gotcha
 */
public class jTunes {
    RandomAccessFile rSongs;
    RandomAccessFile rInvoice;
    
    public jTunes(){
        try {
            rSongs = new RandomAccessFile("jSongs.mus","rw");
            rInvoice = new RandomAccessFile("jDownloads.mus","rw");
            initCods();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    private void initCods() throws IOException{
        RandomAccessFile rCod = new RandomAccessFile("jCods.mus","rw");
        
        if( rCod.length() == 0 ){
            //es nuevo!
            rCod.writeInt(1);
            rCod.writeInt(1);
        }
        
        rCod.close();
    }
}
