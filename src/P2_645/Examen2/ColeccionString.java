/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Examen2;

/**
 *
 * @author Gotcha
 */
public class ColeccionString extends MiColeccion implements iCollection, iCollActions{

    @Override
    public Coleccion getTipo() {
        return Coleccion.STRING;
    }

    @Override
    public void agregar(Object obj) throws ValorMaloException {
        if( obj instanceof String )
            elementos.add(obj);
        else
            throw new ValorMaloException();
    }

    @Override
    public Object sacarElemento(int indice) {
        return elementos.get(indice);
    }

    @Override
    public boolean buscarElemento(Object valor) {
        if( valor instanceof String ){
            for(Object o : elementos ){
                if( o.equals(valor)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
