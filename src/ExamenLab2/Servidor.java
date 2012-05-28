/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
enum TipoProtocolo{ HTTP, DNS }

public abstract class Servidor {
    protected String ip;
    protected ArrayList<ServidorEntry> registros;
    public static final int STANDARD_ID = 233;
    
    public Servidor(String ip){
        this.ip = ip;
        registros = new ArrayList<ServidorEntry>();
    }

    public final String getIp() {
        return ip;
    }
    
    public abstract TipoProtocolo getProtocolo();
    
    private ServidorEntry seEncuentraKey(String key){
        for( ServidorEntry se : registros ){
            if( se.key.equalsIgnoreCase(key) )
                return se;
        }
        return null;
    }
    
    public Object devolverPeticion(String key) throws Exception{
        ServidorEntry se = seEncuentraKey(key);
        if( se != null ){
            return se.registro;
        }
        throw new Exception("La Key " + key + " no existe en el servidor.");
    }
    
    public boolean agregarEntry(String key, Object regis){
        ServidorEntry se = seEncuentraKey(key);
        if( se == null ){
            registros.add( new ServidorEntry( key, regis) );
            return true;
        }
        System.out.println("KEY ya existe");
        return false;
    }
    
    public void printInformacion(){
        System.out.println("Servidor tipo: " + getProtocolo() + " Ip: " + ip);
    }
}
