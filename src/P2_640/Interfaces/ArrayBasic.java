/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_640.Interfaces;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class ArrayBasic {
    protected ArrayList<Object> coleccion;
    protected String nombre;
 
    public ArrayBasic(String n){
        nombre = n;
        coleccion = new ArrayList<Object>();
    }
   
    public String getNombre(){
        return nombre;
    }
    
    
}
