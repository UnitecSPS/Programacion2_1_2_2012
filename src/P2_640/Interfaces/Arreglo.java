/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Interfaces;

/**
 *
 * @author Gotcha
 */
public interface Arreglo {
     //public static final int MAX_VALUE = 300;
    int MAX_VALUE = 300;
    
    void agregarElemento(Object obj);
    Object sacarElemento(int index);
    void imprimir();
}
