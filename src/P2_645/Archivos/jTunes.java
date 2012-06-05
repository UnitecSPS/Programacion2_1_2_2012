/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Archivos;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 *
 * @author Gotcha
 * 
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
    
    private int getCodigo(int offset) throws IOException{
        RandomAccessFile rCod = new RandomAccessFile("jCods.mus","rw");
        
        rCod.seek(offset);
        int cod = rCod.readInt(); //leo el codigo disponible
        rCod.seek( offset ); //me regreso
        rCod.writeInt(cod + 1); //actualizo +1
        rCod.close();
        
        return cod;
    }
    
    public void agregarCancion(String nombre,double precio,TipoGenero genero) throws IOException{
        //me aseguro que el puntero este al final
        rSongs.seek( rSongs.length() );
        //codigo
        rSongs.writeInt( getCodigo(0) );
        //nombre
        rSongs.writeUTF(nombre);
        //precio
        rSongs.writeDouble(precio);
        //genero
        rSongs.writeInt( genero.ordinal() );
        //votaciones
        rSongs.writeInt(0);
        //votantes
        rSongs.writeInt(0);
        //activo
        rSongs.writeBoolean(true);
    }
    
    public boolean buscar(int cancion)throws IOException{
        //desde el inicio
        rSongs.seek(0);
        
        while( rSongs.getFilePointer() < rSongs.length() ){
            long pos = rSongs.getFilePointer();
            int cod = rSongs.readInt();
            rSongs.readUTF(); //avanzo del nombre
            //me muevo para estar justo en el booleano
            rSongs.seek( rSongs.getFilePointer() + 20 );
            
            if( rSongs.readBoolean() ){
                if( cod == cancion ){
                    //dejar el puntero de rSongs en el inicio de ese
                    //registro
                    rSongs.seek(pos);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean votarCancion( int codCancion, int estrellas)throws IOException{
        if( buscar( codCancion ) ){
            
            if( estrellas >= 0 && estrellas <= 5){
            
                //ya el puntero deberia estar en el inicio del registro
                //ver la linea 91 en buscar
                rSongs.readInt(); //paso del codigo
                rSongs.readUTF(); //paso del nombre
                rSongs.readDouble();//paso del precio
                rSongs.readInt();//paso del genero
                
                //saco las votaciones que hay y votantes
                int votaciones = rSongs.readInt();
                int votantes = rSongs.readInt();
                //me regreso para actualizar los datos
                rSongs.seek( rSongs.getFilePointer() - 8 );
                rSongs.writeInt( votaciones + estrellas );
                rSongs.writeInt(votantes + 1);
                
                return true;
            }
        }
        
        return false;
    }
    
    private int estrellas(int votaciones,int votantes){
        try{
            return votaciones/votantes;
        }
        catch(ArithmeticException e){
            //votantes era 0 asi que me genera la excepcion
            //al dividirlo
            return 0;
        }
    }
    
    public void listarDisponibles()throws IOException{
        //desde el inicio
        rSongs.seek(0);
        
        while( rSongs.getFilePointer() < rSongs.length() ){
            int cod = rSongs.readInt();
            String n = rSongs.readUTF();
            double p = rSongs.readDouble();
            int gen = rSongs.readInt();
            int star = rSongs.readInt();
            int vots =  rSongs.readInt();
            
            if( rSongs.readBoolean() ){
                System.out.println(cod + " - " + n + " Lps." + p + 
                        " genero: " + TipoGenero.porOrdinal(gen) + " rate " +
                        estrellas(star,vots) + " estrellas");
            }
        }
    }
    
    public boolean download(int codcancion, String user)throws IOException{
        if( buscar(codcancion) ){
            //datos de la cancion
            int codsong = rSongs.readInt();
            String n = rSongs.readUTF();
            double p = rSongs.readDouble();
            //datos para bajar
            rInvoice.seek( rInvoice.length() );
            //cod factura
            rInvoice.writeInt( getCodigo(4) );
            //cod cancion
            rInvoice.writeInt(codsong);
            //precio
            rInvoice.writeDouble(p);
            //fecha
            rInvoice.writeLong( new Date().getTime() );
            //username
            rInvoice.writeUTF(user);
            
            System.out.println("Felicidades " + user + " has bajado exitosamente " +
                    n);
            return true;
        }        
        return false;
    }
    
    public void listarFacturas()throws IOException{
        rInvoice.seek(0);
        
        while( rInvoice.getFilePointer() < rInvoice.length() ){
            int cf = rInvoice.readInt();
            int cc = rInvoice.readInt();
            double p = rInvoice.readDouble();
            long f = rInvoice.readLong();
            String u = rInvoice.readUTF();
            
            String n = "";
            if( buscar(cc)){
                rSongs.readInt();
                n = rSongs.readUTF();
            }
            
            System.out.println(cf + " - " + " bajo la cancion con codigo " +
                    cc + " : " + n + " a Lps. " + p + " el " + new Date(f) + 
                    " bajado por: " + u);
        }
    }
    
    
    public double montoGenerado(Date i,Date f)throws IOException{
        rInvoice.seek(0);
        double monto = 0;
        while(rInvoice.getFilePointer() < rInvoice.length() ){
            rInvoice.readInt();
            rInvoice.readInt();
            double p = rInvoice.readDouble();
            long fe = rInvoice.readLong();
            Date fbajada = new Date(fe);
            rInvoice.readUTF();
            
            if( fbajada.after(i) && fbajada.before(f) )
                monto += p;
        }
        return monto;
    }
}
