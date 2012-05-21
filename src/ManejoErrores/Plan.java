/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoErrores;

/**
 *
 * @author Gotcha
 */
enum TipoPlan{ 
    
    PERSONAL(100), CORPORATIVO(200), TARJETA(50);
    int maxmins;
    
    TipoPlan(int mm){
        maxmins = mm;
    }
    
    int getMaxMins(){
        return maxmins;
    }
}



public class Plan {
    TipoPlan tp;
    String nombre;
    
    public Plan(String n){
        nombre = n;
    }
    
    /***
     * Esta funcion es para bla bla bla
     * @param t El valor del plan
     * @throws InvalidPlanException si el tipo plan es incorrecto
     */
    public void setPlan(String t){
        try{
            tp = TipoPlan.valueOf(t);
        }
        catch(IllegalArgumentException ie){
            throw new InvalidPlanException("El Tipo es Incorrecto");
        }
    }
   
    
}





