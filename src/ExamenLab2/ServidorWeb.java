/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

/**
 *
 * @author Gotcha
 */
public class ServidorWeb extends Servidor{
    public ServidorWeb(String ip){
        super(ip);
    }

    @Override
    public TipoProtocolo getProtocolo() {
        return TipoProtocolo.HTTP;
    }

    @Override
    public boolean agregarEntry(String key, Object regis) {
        if( super.agregarEntry(key, regis) )
            return true;
        throw new RuntimeException("URL ya existe");
    }
    
    
}
