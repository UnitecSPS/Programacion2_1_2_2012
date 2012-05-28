/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

/**
 *
 * @author Gotcha
 */
public class ServidorDNS extends Servidor{
    
    public ServidorDNS(String ip){
        super( ip );
    }

    @Override
    public TipoProtocolo getProtocolo() {
        return TipoProtocolo.DNS;
    }

    @Override
    public boolean agregarEntry(String key, Object regis) {
        if( super.agregarEntry(key, regis) )
            return super.agregarEntry(regis.toString(), key);
        return false;
    }
    
    
    
    
}
