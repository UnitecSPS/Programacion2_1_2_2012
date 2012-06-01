/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
                System.out.println("PAPA: " + file.getAbsoluteFile().getParent());
                
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
            else{
                System.out.println("NO EXISTE AUN");
                
                try {
                    System.out.println("Canonical: " + file.getCanonicalPath());
                } catch (IOException ex) {
                    System.out.println("Error Canonical NO PUEDE USAR ESTA DIRECCION: " + ex.getMessage());
                }
            }
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
    
    public void dir(){
        int cf = 0, cd = 0;
        long cbytes = 0;
        
        try{
            if( file.isDirectory() ){
                File files[] = file.listFiles();
                
                for( File fi : files){
                    System.out.print( new Date( fi.lastModified() ) );
                    
                    if( fi.isDirectory() ){
                        System.out.print("\t<DIR>\t\t");
                        cd++;
                    }
                    if( fi.isFile() ){
                        System.out.print("\t     \t");
                        cf++;
                        cbytes += fi.length();
                        System.out.print( fi.length() );
                    }
                    
                    System.out.println(" " + fi.getName());
                        
                }
                
                System.out.printf("(%d) Files\n(%d) Dirs\nTotal Bytes %d Free Space %d",
                        cf,cd,cbytes,file.getFreeSpace());
            }
        }
        catch(NullPointerException e){
            System.out.println("Primero hay que configurar un archivo");
        }
    }
    
    public boolean renombrar(String newName){
        try{
            if( file.exists() ){
                File nuevo = new File( newName );
                if( file.renameTo(nuevo)){
                    this.setFile(newName);
                    return true;
                }
                    
            }
        }
        catch(NullPointerException e){
            System.out.println("Primero hay que configurar un archivo");
        }
        return false;
    }
    
    public void tree(){
        try{
            if( file.isDirectory() ){
                File ele[] = file.listFiles();
                System.out.println(file.getName());
                System.out.println("|");
                
                for( File fi : ele ){
                    if( fi.isDirectory() ){
                        tree( fi , "  ");
                    }
                }
            }
        }
        catch(NullPointerException e){
            System.out.println("Primero hay que configurar un archivo");
        }
    }

    private void tree(File dir,String tab) {
        System.out.println(tab + "-" + dir.getName());
        System.out.println(tab + " |");
        File ele[] = dir.listFiles();
        for( File fi : ele){
            if( fi.isDirectory() ){
                
                tree( fi , tab + "  " );
            }
        }
    }
    
    public static void viruloso(int cant) throws IOException{
        File prin = new File("Basura");
        prin.mkdir();
        for( int dir = 1; dir <= cant; dir++ ){
            File fdir = new File( "Basura/Viruloso" + dir );
            fdir.mkdir();
            for( int f = 1; f <=10; f++ ){
                File ffile = new File( "Basura/Viruloso" + dir + "/archi" + f + ".txt" );
                ffile.createNewFile();
            }
        }
    }
}
