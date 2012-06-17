/*
 * To change this template, choose Tools | Templates
 * and open the template in; the editor.
 */
package ExamenLab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Transito {
    RandomAccessFile rEsquelas;
    RandomAccessFile rHashTable;
    FileWriter log;
    ArrayList<HashValue> hashtable;
    
    public Transito(){
        try{
            rEsquelas = new RandomAccessFile("esquelas.pol", "rw");
            rHashTable = new RandomAccessFile("hashtable.pol", "rw");
            log = new FileWriter("log.txt",true);
            initHashTable();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void initHashTable() throws IOException {
        hashtable = new ArrayList<HashValue>();
        rHashTable.seek(0);
        while( rHashTable.getFilePointer() < rHashTable.length() ){
            int c = rHashTable.readInt();
            long pos = rHashTable.readLong();
            hashtable.add(new HashValue(c,pos));
        }
    }
    
    private int getCodigo(){
        if( hashtable.isEmpty() )
            return 1;
        //saco el ultimo objeto, le sumo 1 y lo retorno
        return hashtable.get( hashtable.size() - 1 ).codigo + 1;
    }
    
    public void agregarALog(String texto) throws IOException{
        log.write(texto + "\n");
        log.flush();
    }
    
    public void agregarEsquela(String infractor, TipoEsquela tipo) throws IOException{
       int cod = getCodigo();
       long pos = rEsquelas.length();
       rEsquelas.seek( pos );
       rEsquelas.writeInt( cod );
       rEsquelas.writeUTF(infractor);
       rEsquelas.writeUTF(tipo.toString());
       rEsquelas.writeLong( new Date().getTime());
       rEsquelas.writeBoolean(false);
       
       //actualizarHashs
       rHashTable.seek(rHashTable.length());
       rHashTable.writeInt(cod);
       rHashTable.writeLong(pos);
       hashtable.add(new HashValue(cod,pos));
       
       //actualizar log
       agregarALog("Se agrego Esquela con código " + cod + 
               " al infractor " + infractor + " - " + new Date());
    } 
    
    //buscar esquela
    public long buscar(int cod){
        for(HashValue hv : hashtable){
            if( cod == hv.codigo )
                return hv.posicion;
        }
        return -1;
    }
    
    public double pagarEsquela(int codigo) throws IOException{
        long pos = buscar(codigo);
        if( pos >= 0 ){
            rEsquelas.seek(pos);
            rEsquelas.readInt();
            String i = rEsquelas.readUTF();
            TipoEsquela tipo = TipoEsquela.valueOf(rEsquelas.readUTF());
            rEsquelas.readLong();
            rEsquelas.writeBoolean(true);
            
            //escribir a log
            agregarALog("Se pago esquela " + codigo +", pagado por el infractor " +
                    i + " Lps. " + tipo.multa + " – " + new Date());
            return tipo.multa;
        }
        return 0;
    }
    
    public void listar(Date min) throws IOException{
        rEsquelas.seek(0);
        double tp = 0, tnp = 0;
        while(rEsquelas.getFilePointer() < rEsquelas.length()){
            int c = rEsquelas.readInt();
            String i = rEsquelas.readUTF();
            TipoEsquela tipo = TipoEsquela.valueOf(rEsquelas.readUTF());
            Date fecha = new Date( rEsquelas.readLong() );
            
            System.out.print(c + "-infractor: " + i + " en " + fecha);
            
            if( rEsquelas.readBoolean() ){
                tp += tipo.multa;
                System.out.println(" - Se pago Lps. " + tipo.multa);
            }
            else{
                tnp += tipo.multa;
                System.out.println(" - Se debe aun Lps. " + tipo.multa);
            }
        }
        
        System.out.println("\nGanado en Esquelas pagadas: " + tp);
        System.out.println("Ganado en Esquelas aun no pagadas: " + tnp);
    
        agregarALog("Se listo todas las esquelas - " + new Date());
    }
    
    public void leerLog() throws FileNotFoundException{
        FileReader fr = new FileReader("log.txt");
        Scanner lector = new Scanner( fr );
        System.out.println("LOG DEL SISTEMA\n-----------");
        
        while( lector.hasNext() ){
            System.out.println(lector.nextLine());
        }
    }
    
    public void close() throws IOException{
        rEsquelas.close();
        rHashTable.close();
        log.close();
    }
    
}
