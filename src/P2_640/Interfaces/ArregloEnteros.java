/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Interfaces;

/**
 *
 * @author Gotcha
 */
public class ArregloEnteros extends ArrayBasic implements Arreglo {
    public ArregloEnteros(){
        super("Enteros");
    }

    @Override
    public void agregarElemento(Object obj) {
        if( obj instanceof Integer )
            coleccion.add(obj);
    }

    @Override
    public Object sacarElemento(int index) {
        if( index < coleccion.size() )
            return coleccion.get(index);
        return null;
    }

    @Override
    public void imprimir() {
        for(Object e : coleccion){
            System.out.println("dato: " + e);
        }
    }
}
