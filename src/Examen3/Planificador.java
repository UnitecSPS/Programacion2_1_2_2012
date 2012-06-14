/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Planificador {
    RandomAccessFile rTareas;
    RandomAccessFile rRespon;
    
    public Planificador(){
        try{
            rTareas = new RandomAccessFile("tareas.pln", "rw");
            rRespon = new RandomAccessFile("responsables.pln","rw");
        }catch(Exception e){
            
        }
    }
    
    public boolean buscarTarea(int cod) throws IOException{
        rTareas.seek(0);
        
        while(rTareas.getFilePointer() < rTareas.length() ){
            if( rTareas.readInt() == cod )
                return true;
            rTareas.readInt();
            rTareas.readUTF();
            rTareas.readLong();
            rTareas.readBoolean();
        }
        
        return false;
    }
    
    public boolean buscarRespon(int cod) throws IOException{
        rRespon.seek(0);
        
        while(rRespon.getFilePointer() < rRespon.length() ){
            if( rRespon.readInt() == cod )
                return true;
            rRespon.readUTF();
            rRespon.readInt();
        }
        return false;
    }
    
    public void agregar(int cod,int rid, String desc) throws IOException{
        Scanner lea = new Scanner(System.in);
        
        if( !buscarTarea(cod) ){
            if( buscarRespon(rid) ){
                Calendar c = Calendar.getInstance();
                c.set(lea.nextInt(), lea.nextInt()-1,lea.nextInt());
                
                rTareas.writeInt(cod);
                rTareas.writeInt(rid);
                rTareas.writeUTF(desc);
                rTareas.writeLong(c.getTime().getTime());
                rTareas.writeBoolean(false);
            }
            else
                throw new NoSuchResponsableException();
        }
        else
            throw new NoUniqueException();
    }
    
    public void agregarRespon(int cod,String n) throws IOException{
        if( !buscarRespon(cod) ){
            rRespon.seek(rRespon.length());
            rRespon.writeInt(cod);
            rRespon.writeUTF(n);
            rRespon.writeInt(100);    
        }
    }
    
    public void completarTarea(int cod)throws IOException{
        if( buscarTarea(cod) ){
            int res = rTareas.readInt();
            rTareas.readUTF();
            long limite = rTareas.readLong();
            rTareas.writeBoolean(true);
            
            if( buscarRespon(res)){
                rRespon.readUTF();
                int score = calcularScore(limite,rRespon.readInt());
                rRespon.seek(rRespon.getFilePointer() - 4);
                rRespon.writeInt(score);
            }
        }
    }

    private int calcularScore(long limite, int score){
        Date now = new Date();
        long diff = now.getTime() - limite;
        long dias = diff/(1000*60*60*24);
        
        if( diff < 0 )
            return score + ((int)dias * -10);
        else
            return score - ((int)dias * 5);
    }
    
    public void listarMora()throws IOException{
        rTareas.seek(0);
        while( rTareas.getFilePointer() < rTareas.length() ){
            int cod = rTareas.readInt();
            int res = rTareas.readInt();
            String desc = rTareas.readUTF();
            long limite = rTareas.readLong();
            
            if( !rTareas.readBoolean() ){
                String nombre = "NO RESPONSABLE";
                if( buscarRespon(res) )
                    nombre = rRespon.readUTF();
                long dias = ((new Date().getTime()-limite)/(1000*60*60*24));
                System.out.println(cod + "-" + desc + "-" + nombre + 
                        " faltan " + dias + " dias para completarlo");
            }
        }
    }
}

