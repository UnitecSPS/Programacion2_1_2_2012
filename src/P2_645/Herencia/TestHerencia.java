/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package P2_645.Herencia;

/**
 *
 * @author Gotcha
 */
public class TestHerencia {
    public static void main(String args[]){
        //UPCASTINGS
        Empleado em1 = new EmpleadoPermanente(1,"ssdsd",5000);
        Empleado em2 = new EmpleadoTemporal(3,"Messi",4500);
        //NORMAL
        Empleado em3 = new Empleado(2,"Sergio");
        
        em1.fua();
        em2.fua();
        em3.fua();
        
       
    }
}
