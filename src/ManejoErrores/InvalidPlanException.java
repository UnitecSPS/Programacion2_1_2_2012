/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoErrores;

/**
 *
 * @author Gotcha
 */
public class InvalidPlanException extends RuntimeException{
    public InvalidPlanException(String ms){
        super(ms);
    }
}
