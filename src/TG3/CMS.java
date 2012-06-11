package TG3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CMS {
    RandomAccessFile rArticles;
    RandomAccessFile rAuthors;
    Scanner lea = new Scanner(System.in);
    
    public CMS() {
        try {
            rArticles = new RandomAccessFile("articles.cms ","rw");
            rAuthors = new RandomAccessFile("authors.cms","rw");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public boolean agregarAutor(int codigo, String nombre){
        try {
            if(getAutor(codigo).equals("")){
                rAuthors.seek(rAuthors.length());
                rAuthors.writeInt(codigo);
                rAuthors.writeUTF(nombre);
                return true;
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return false;
    } 
    
    private String getAutor(int codigo) throws IOException{
        rAuthors.seek(0);
        while(rAuthors.getFilePointer()<rAuthors.length()){
            if(codigo==rAuthors.readInt()){
                return rAuthors.readUTF();
            }
            rAuthors.readUTF();
        }
        return "";
    }
    
    private int sacarArticuloCod() throws IOException{
        int cod = 0;
        rArticles.seek(0);
        while(rArticles.getFilePointer()<rArticles.length()){
            cod = rArticles.readInt();
            rArticles.readUTF();
            rArticles.readUTF();
            rArticles.seek(rArticles.getFilePointer()+16);
        }
        return cod+1;
    }
    
    private long fechaCorrecta() {
        Date publicar = new Date();
        
        do{
            System.out.println("Ingrese Fecha a Publicar yy/mm/dd: ");
            Calendar c = Calendar.getInstance();
            c.set(lea.nextInt(), lea.nextInt() - 1 , lea.nextInt());
            
            if( c.getTime().getTime() >= new Date().getTime() )
                break;
            else
                System.out.println("Fecha Incorrecta ingrese otra vez " +
                        "Debe ser Mayor o igual que HOY");
        }while(true);
                
        return publicar.getTime();        
    }
    
    public boolean crearArticulo(String titulo, String contenido)throws IOException{
      
        System.out.println("Ingrese el codigo del autor: ");
        int aId = lea.nextInt();
        
        if( getAutor(aId).equals("")){
            System.out.println("NO EXISTE AUTOR");
            return false;
        }
            
        rArticles.writeInt(sacarArticuloCod());
        rArticles.writeUTF(titulo);
        rArticles.writeUTF(contenido);
        rArticles.writeLong(fechaCorrecta());
        rArticles.writeInt(aId);
        rArticles.writeInt(0);
        return true;
    }
    
    public void blog() throws IOException{
        rArticles.seek(0);
        System.out.println("\nPublicaciones     --------------------------------\n");
        while(rArticles.getFilePointer() < rArticles.length()){
            int cod = rArticles.readInt();
            String titulo = rArticles.readUTF();
            rArticles.readUTF();
            long fecha = rArticles.readLong();
            String autor = getAutor(rArticles.readInt());
            int vecesL = rArticles.readInt();
            
            Date publica = new Date(fecha);
            //si la fecha es menor o igual a hoy
            if( publica.compareTo(new Date()) <= 0 )
                System.out.print(cod+" - "+titulo+autor+" Veces Leido: "+vecesL);
        }
    }

    public void leerArticulo(int codigo)throws IOException{
        rArticles.seek(0);
        
        while(rArticles.getFilePointer() < rArticles.length()){

            int cods = rArticles.readInt();
            String ti = rArticles.readUTF();
            String con = rArticles.readUTF();
            long f = rArticles.readLong();
            int id = rArticles.readInt();
            long pos = rArticles.getFilePointer();
            int leidos = rArticles.readInt();

            if(cods == codigo){
                rArticles.seek(pos);
                rArticles.writeInt(leidos+1);
                System.out.println(ti);
                System.out.println("-------------");
                System.out.println(con);
                System.out.println("Por: " + getAutor(id) + "el " + new Date(f));
                return;
            }
             
        }

        System.out.println("El codigo no existe");
        
    }
    
}
