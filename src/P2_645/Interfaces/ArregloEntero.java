/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Interfaces;

/**
 *
 * @author Gotcha
 */
public class ArregloEntero extends ArrayBasic implements ArrayActions, ArrayEffects{

    @Override
    public void imprimir() {
        for(Object o : coleccion)
            System.out.println(o);
    }

    @Override
    public void agregarElemento(Object obj) {
        if( obj instanceof Integer )
            coleccion.add(obj);
    }

    @Override
    public Object sacarElemento(int index) {
        return coleccion.get(index);
    }

    @Override
    public boolean compare(Object ab) {
        return true;
    }

    @Override
    public void sortArray() {
        //TODO: Sort Array
    }
    
}
