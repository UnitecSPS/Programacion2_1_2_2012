/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoErrores;

import java.io.IOException;

/**
 *
 * @author Gotcha
 */
public class ArregloEntero {
    public Object valores[] = new Object[10];
    
    public void guardarEn(int index,  Object valor) throws InvalidValueException{
        if( valor instanceof Integer )
            valores[ index ] = valor;
        else
            throw new InvalidValueException("Valor " + valor + " No Aceptado");
    }
}
