/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Examen2;

/**
 *
 * @author Gotcha
 */
public interface iCollection {
    Coleccion getTipo();
    void agregar( Object obj ) throws ValorMaloException;
    Object sacarElemento( int indice );
}
