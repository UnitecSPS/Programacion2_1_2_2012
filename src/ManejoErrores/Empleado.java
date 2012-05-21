/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoErrores;

/**
 *
 * @author Gotcha
 */
public class Empleado {
    public String nombre;
    public char zona;
    
    public Empleado(String n){
        nombre = n;
    }
    
    public void setZona( char z ) throws ZonaInvalidaException{
        switch( z ){
            case 'a':
            case 'b':
            case 'c':
                zona = z;
                break;
            default:
                throw new ZonaInvalidaException("Zona Invalida");
        }
    }
}
