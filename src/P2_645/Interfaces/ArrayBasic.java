/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Interfaces;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public abstract class ArrayBasic {
    protected ArrayList<Object> coleccion;
    public final static int MAX_VALUE = 300;
    
    public ArrayBasic(){
        coleccion = new ArrayList<Object>();
    }
    
    public abstract void imprimir();
}
