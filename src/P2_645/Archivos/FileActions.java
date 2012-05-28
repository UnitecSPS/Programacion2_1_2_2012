/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gotcha
 */
public class FileActions {
    File file = null;
    
    public void setFile(String path){
        file = new File( path );
    }
    
    public boolean crearArchivo()throws IOException{
        try{
            return file.createNewFile();
        }
        catch(NullPointerException e){
            System.out.println("Primero hay que configurar un archivo");
            return false;
        }
    }
    
    public boolean crearDirectorio(){
        try{
            return file.mkdirs();
        }
        catch(NullPointerException e){
            System.out.println("Primero hay que configurar un archivo");
            return false;
        }
    }
    
    public void info(){
        try{
            if( file.exists() ){
                System.out.println("Nombre: " + file.getName());
                System.out.println("Path: " + file.getPath());
                System.out.println("Absoluto: " + file.getAbsolutePath());
                try {
                    System.out.println("Canonical: " + file.getCanonicalPath());
                } catch (IOException ex) {
                    System.out.println("Error Canonical: " + ex.getMessage());
                }
                
                if( file.isDirectory() )
                    System.out.println("Es Directorio");
                if( file.isFile() )
                    System.out.println("ES un Archivo");
                if( file.isHidden() )
                    System.out.println("Esta Escondido");
                if( file.isAbsolute() )
                    System.out.println("Creado con Direccion Absoluta");
                
                Date fecha = new Date( file.lastModified()  );
                System.out.println("Ultima Fecha de Modificacion: " + fecha);
                System.out.println("Size en Bytes: " + file.length());
                
                
            }
            else
                System.out.println("NO EXISTE AUN");
        }
        catch(NullPointerException e){
            System.out.println("Primero hay que configurar un archivo");
        }
        
    }
    
    public boolean borrar(){
        try{
            return file.delete();
        }
        catch(NullPointerException e){
            System.out.println("Primero hay que configurar un archivo");
        }
        return false;
    }
}
