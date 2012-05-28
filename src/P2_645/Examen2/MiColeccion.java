/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Examen2;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */

enum Coleccion { STRING, INTEGER, DOUBLE, CHAR }

public class MiColeccion {
    protected ArrayList<Object> elementos;
    
    public void imprimirColeccion(){
        for(Object o : elementos)
            System.out.println(o);
    }   
}
