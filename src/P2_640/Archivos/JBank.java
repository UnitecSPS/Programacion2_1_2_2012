/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author CarlosArmando
 */
public class JBank {
    RandomAccessFile rCuentas;
    RandomAccessFile rLog;
    public final static double TASA_INTERES = 0.08;
    
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
    
    private int getCodigo( )throws IOException{
        RandomAccessFile rCod = new RandomAccessFile("codigos.bac","rw");
        
        int cod = rCod.readInt(); //leo el codigo disponible
        rCod.seek(0); //me regreso de nuevo
        rCod.writeInt(cod + 1);//actualizo el archivo
        rCod.close();
        
        return cod;
    }
    
    public void addCuenta( String cliente )throws IOException{
        //me voy al final
        rCuentas.seek( rCuentas.length() );
        //escribo el codigo
        rCuentas.writeInt( getCodigo() );
        //nombre
        rCuentas.writeUTF(cliente);
        //saldo
        rCuentas.writeDouble(500);
        //fecha ultima
        rCuentas.writeLong( new Date().getTime() );
        //activo
        rCuentas.writeBoolean(true);
    }
    
    public void listar(boolean activas)throws IOException{
        //desde el inicio
        rCuentas.seek(0);
        
        while( rCuentas.getFilePointer() < rCuentas.length() ){
            int cod = rCuentas.readInt();
            String client = rCuentas.readUTF();
            double sal = rCuentas.readDouble();
            long fechault = rCuentas.readLong();
            
            if( rCuentas.readBoolean() == activas ){
                System.out.println(cod + "-" + client + " Lps " + sal +
                        " ultima vez usada: " + new Date(fechault) );
            }
        }
    }
    
    public boolean buscar(int codcuenta)throws IOException{
        //desde el inicio
        rCuentas.seek(0);
        while( rCuentas.getFilePointer() < rCuentas.length() ){
            //guardo la pos antes de comenzar a leer el registro
            long pos = rCuentas.getFilePointer();
            
            int cod = rCuentas.readInt();
            rCuentas.readUTF();
            //me salto el saldo + fecha + activo = 17 bytes
            rCuentas.seek( rCuentas.getFilePointer() + 17);
            
            if( cod == codcuenta ){
                rCuentas.seek(pos);
                return true;
            }
            
        } 
        return false;
    }
    
    private void addTransaccion(int cc,double m,Transaccion t) throws IOException{
        rLog.seek( rLog.length() );
        rLog.writeInt(cc);
        rLog.writeDouble(m);
        rLog.writeUTF(t.toString());
        rLog.writeLong( new Date().getTime() );
    }
    
    private boolean transaccionBancaria(int cc,double m,Transaccion tp) throws IOException{
        if( buscar(cc) ){
            rCuentas.readInt();
            rCuentas.readUTF();
            long pos = rCuentas.getFilePointer();
            double s = rCuentas.readDouble();
            rCuentas.readLong();
            
            if( tp == Transaccion.RETIRO && s < m ){
                System.out.println("Saldos Insuficientes");
                return false;
            }
            
            if( !rCuentas.readBoolean() ){
                addTransaccion(cc,m*0.1, Transaccion.ACTIVACION);
                m -= m * 0.1;
            }
            
            //depositar o retirar
            addTransaccion(cc, m, tp);
            
            //actualizar cuenta
            rCuentas.seek(pos);
            rCuentas.writeDouble(s + (tp == Transaccion.DEPOSITO ? m : -m));
            rCuentas.writeLong( new Date().getTime() );
            rCuentas.writeBoolean(true);
            return true;
        }
        
        return false;
    }
    
    public boolean deposito(int cc,double m) throws IOException{
        return transaccionBancaria(cc, m, Transaccion.DEPOSITO);
    }
    
    public boolean retiro(int cc, double m) throws IOException{
        return transaccionBancaria(cc, m, Transaccion.RETIRO);
    }
    
    /**
     * Hacer una funcion que recorre el archivo de cuentas.
     * Si la ultima fecha de modificacion fue hace mas de 6 meses
     * la cuenta es inactivada
     */
    public void inactivarCuentas() throws IOException{
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -6);
        long mili6 = c.getTime().getTime();
        
        rCuentas.seek(0);
        while( rCuentas.getFilePointer() < rCuentas.length() ){
            int cc = rCuentas.readInt();
            String cl = rCuentas.readUTF();
            rCuentas.readDouble();
            long f = rCuentas.readLong();
            
            if( f < mili6 ){
                System.out.println("Inactivando Cuenta #" + cc + 
                        " de cliente: " + cl);
                rCuentas.writeBoolean(false);
            }
            else
                rCuentas.readBoolean();
        }
    }
    
    /**
     * Imprimir todas las transacciones de una cuenta. Dichas
     * transacciones tienen que haber sido realizadas no antes de la
     * fecha minima. Imprimir consolidado final es decir
     * Cuanto de deposito, retiro, intereses o activacion
     * @param cc Codigo de la cuenta
     * @param min Fecha minima
     */
    public void libreta(int cc,Date min) throws IOException{
        rLog.seek(0);
        double tDeposito = 0,tRetiro=0,tInt=0,tAct=0;
        boolean tiene1 = false;
        
        while(rLog.getFilePointer() < rLog.length() ){
            int cod = rLog.readInt();
            double m = rLog.readDouble();
            String t = rLog.readUTF();
            long fecha = rLog.readLong();
            
            if( cod == cc && fecha >= min.getTime() ){
                System.out.println(t + " Lps " + m + " " +
                        new Date(fecha) );
                tiene1 = true;
                switch( Transaccion.valueOf(t) ){
                    case DEPOSITO:
                        tDeposito += m;
                        break;
                    case RETIRO:
                        tRetiro += m;
                        break;
                    case INTERESES:
                        tInt += m;
                        break;
                    default:
                        tAct += m;
                        break;
                        
                }
            }
        }
        
        if( tiene1 ){
            System.out.println("Total Depositado: " + tDeposito);
            System.out.println("Total Retiado: " + tRetiro);
            System.out.println("Total Intereses: " + tInt);
            System.out.println("Total Activaciones: " + tAct );
        }
        else
            System.out.println("CLIENTE NO TIENE TRANSACCIONES");
    }
    
    /**
     * Recorre todos las cuentas registrando los intereses
     * Recuerden que los intereses le suman al saldo. Ademas
     * se guarda una transaccion de intereses para cada cuenta
     * NOTA= Si la cuenta esta inactiva NO gana intereses.
     */
    public void registrarIntereses() throws IOException{
        rCuentas.seek(0);
        
        while( rCuentas.getFilePointer() < rCuentas.length() ){
            int cc = rCuentas.readInt();
            rCuentas.readUTF();
            long pos = rCuentas.getFilePointer();
            double sal = rCuentas.readDouble();
            rCuentas.readLong();
            
            if( rCuentas.readBoolean() ){
                rCuentas.seek( pos );
                double inter = sal * TASA_INTERES;
                rCuentas.writeDouble(sal + inter);
                addTransaccion( cc, inter, Transaccion.INTERESES);
                
                rCuentas.seek( rCuentas.getFilePointer() + 9);
            }
        }
    }
    
    public void exportarCuentas(String path)throws IOException{
        rCuentas.seek(0);
        double tsal = 0;
        int cactivos = 0, cinactivos = 0;
        
        FileWriter fw = new FileWriter(path);
        fw.write("Listado de Cuentas\n-----------------\n");
        
        while( rCuentas.getFilePointer() < rCuentas.length() ){
            int cod = rCuentas.readInt();
            String n = rCuentas.readUTF();
            double sal = rCuentas.readDouble();
            tsal += sal;
            long ult = rCuentas.readLong();
            boolean act = rCuentas.readBoolean();
            
            String dato = cod + " - " + n + " Lps. " + sal;
            
            if( act ){
                long diff = new Date().getTime() - ult;
                long dias = diff/(1000*60*60*24);
                dato += " Usado hace " + dias + " dias";
                cactivos++;
            }
            else{
                dato += " INACTIVA";
                cinactivos++;
                        
            }
            
            fw.write(dato + "\n");
        }
        
        fw.write("Total en Saldos: " + tsal + "\n");
        fw.write("Total Activas: " + cactivos + "\n");
        fw.write("Total Inactivas: " + cinactivos);
        fw.close();
    }
}
